package com.leetcode.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JumpGame
{
	public boolean canJump(int[] nums)
	{
		Set<Integer> visitedIndices = new HashSet<Integer>();
		Set<Integer> nodesToVisit = new HashSet<Integer>();

		if (nums.length < 2)
		{
			return true;
		}

		nodesToVisit.add(0);
		while (!nodesToVisit.isEmpty())
		{
			ArrayList<Integer> nodesVisitingNow = new ArrayList<Integer>(nodesToVisit);
			nodesToVisit.clear();
			for (int i = 0; i < nodesVisitingNow.size(); i++)
			{
				visitedIndices.add(nodesVisitingNow.get(i));

				Integer index = nodesVisitingNow.get(i);
				Integer jumpVal = nums[index];
				while (jumpVal > 0)
				{
					if ((index + jumpVal) < nums.length && !visitedIndices.contains(index + jumpVal))
					{
						nodesToVisit.add(index + jumpVal);
					}
					if ((index - jumpVal) > 0 && !visitedIndices.contains(index - jumpVal))
					{
						nodesToVisit.add(index - jumpVal);
					}
					jumpVal--;
				}
			}

			if (visitedIndices.contains(nums.length - 1))
			{
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		// int[] nums = { 2, 3, 1, 1, 4 };
		// int[] nums = { 3, 2, 1, 0, 4 };
		// int[] nums = { 2, 0 };
		// int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		int[] nums = { 1, 2, 2, 6, 3, 6, 1, 8, 9, 4, 7, 6, 5, 6, 8, 2, 6, 1, 3, 6, 6, 6, 3, 2, 4, 9, 4, 5, 9, 8, 2, 2, 1, 6, 1, 6, 2, 2, 6, 1, 8, 6, 8, 3, 2, 8,
				5, 8, 0, 1, 4, 8, 7, 9, 0, 3, 9, 4, 8, 0, 2, 2, 5, 5, 8, 6, 3, 1, 0, 2, 4, 9, 8, 4, 4, 2, 3, 2, 2, 5, 5, 9, 3, 2, 8, 5, 8, 9, 1, 6, 2, 5, 9, 9,
				3, 9, 7, 6, 0, 7, 8, 7, 8, 8, 3, 5, 0 };
		
		
		

		final long startTime = System.currentTimeMillis();
		
		boolean canJump = new JumpGame().canJump(nums);
		
		final long duration = System.currentTimeMillis() - startTime;
		System.out.println((double)duration/1000);
		System.out.println("Result: " + canJump);
		
		
	}

}
