package com.leetcode.problem;

public class JumpGame
{
	public boolean canJump(int[] nums)
	{
		if (nums.length <= 1) return true;

		int max = nums[0]; // max stands for the largest index that can be reached.

		for (int i = 0; i < nums.length; i++)
		{
			// if not enough to go to next
			if (max <= i && nums[i] == 0)
			{
				return false;
			}

			// update max
			if (i + nums[i] > max)
			{
				max = i + nums[i];
			}

			// max is enough to reach the end
			if (max >= nums.length - 1)
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
		System.out.println((double) duration / 1000);
		System.out.println("Result: " + canJump);

	}

}
