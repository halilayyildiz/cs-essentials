package com.leetcode.problem;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence
{
	public int longestConsecutive(int[] nums)
	{
		if (nums.length < 2)
		{
			return nums.length;
		}

		int max = 0;
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++)
		{
			set.add(nums[i]);
		}
		
		for (int i = 0; i < nums.length; i++)
		{
			if (!set.contains(nums[i] - 1))
			{
				int next = nums[i] + 1;
				int curLen = 1;
				while (set.contains(next))
				{
					curLen++;
					next++;
				}

				max = Math.max(curLen, max);
			}
		}

		return max;
	}

	public static void main(String[] args)
	{
		int[] nums = { 100, 4, 200, 1, 3, 2, 50, 51, 53, 52, 54 };
		System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
	}
}
