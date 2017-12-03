package com.leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule
{
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        int[] incomingEdges = new int[numCourses];
        Set<Integer> coursesTaken = new HashSet<>();
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
            incomingEdges[prerequisites[i][0]]++;
        }

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet())
        {
            for (Integer node : entry.getValue())
            {
                startNodes.remove(node);
            }
        }
        if (startNodes.isEmpty())
        {
            return false;
        }

        Queue<Integer> nodes = new LinkedList<Integer>(startNodes);
        while (!nodes.isEmpty())
        {
            Integer node = nodes.poll();
            if (coursesTaken.contains(node))
            {
                // cycle detected
                return false;
            }
            coursesTaken.add(node);
            for (Integer outgoingNode : graph.get(node))
            {
                incomingEdges[outgoingNode]--;
                if (incomingEdges[outgoingNode] == 0)
                {
                    nodes.add(outgoingNode);
                }
            }
        }

        return coursesTaken.size() == numCourses;
    }

    public static void main(String[] args)
    {
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 2, 3 }, { 4, 2 }, { 3, 4 }, { 6, 3 }, { 5, 4 } };
        System.out.println(new CourseSchedule().canFinish(7, prerequisites));
    }

}
