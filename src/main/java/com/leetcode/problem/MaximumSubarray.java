package com.leetcode.problem;

public class MaximumSubarray
{
    public int maxSubArray(int[] nums)
    {
        int max = Integer.MIN_VALUE;
        int subArrayMax = 0;

        for (int i = 0; i < nums.length; i++)
        {
            subArrayMax += nums[i];
            max = Math.max(max, subArrayMax);
            subArrayMax = Math.max(subArrayMax, 0);
        }

        return max;
    }

    public static void main(String[] args)
    {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
}
