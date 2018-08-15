package com.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CourseSchedule2
{
	private boolean cyclic = false;

	public int[] findOrder(int numCourses, int[][] prerequisites)
	{
		Map<Integer, List<Integer>> graph = new HashMap<>();

		Set<Integer> startNodes = new HashSet<>();
		for (int i = 0; i < numCourses; i++)
		{
			startNodes.add(i);
			graph.put(i, new ArrayList<>());
		}

		for (int i = 0; i < prerequisites.length; i++)
		{
			graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}

		Set<Integer> visitedNodes = new HashSet<>();
		Stack<Integer> stack = new Stack<>();

		List<Integer> nodes = new ArrayList<>(graph.keySet());
		for (int i = 0; i < nodes.size(); i++)
		{
			if (!cyclic && !visitedNodes.contains(nodes.get(i)))
			{
				topologicalSortUtil(nodes.get(i), visitedNodes, new HashSet<>(), stack, graph);
			}
		}

		if (cyclic)
		{
			return new int[] {};
		}

		int[] result = new int[stack.size()];
		for (int i = 0; !stack.isEmpty(); i++)
		{
			result[i] = stack.pop();
		}

		return result;
	}

	private void topologicalSortUtil(int node, Set<Integer> visited, Set<Integer> discovered, Stack<Integer> stack, Map<Integer, List<Integer>> graph)
	{
		visited.add(node);
		discovered.add(node);

		Iterator<Integer> it = graph.get(node).iterator();
		while (it.hasNext())
		{
			int outGoingNode = it.next();
			if (discovered.contains(outGoingNode))
			{
				cyclic = true;
				break;
			}
			if (!visited.contains(outGoingNode))
			{
				topologicalSortUtil(outGoingNode, visited, discovered, stack, graph);
			}
		}
		discovered.remove(node);

		stack.push(node);
	}

	public static void main(String[] args)
	{
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 2, 3 }, { 3, 4 }, { 6, 3 }, { 5, 4 } };
		Arrays.stream(new CourseSchedule2().findOrder(7, prerequisites)).forEach(node -> System.out.print(node + " "));
	}

}
