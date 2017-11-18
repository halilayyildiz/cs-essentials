package com.leetcode.problem;

import java.util.Arrays;

public class LongestIncreasingSubsequence
{
    public int lengthOfLIS(int[] nums)
    {
        int longestLen = 1;
        int[] dp = new int[nums.length];

        if (nums.length < 2)
        {
            return nums.length;
        }

        dp[0] = 1;
        for (int i = 0; i < nums.length; i++)
        {
            // Arrays.binarySearch

            int maxLen = 0;
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    maxLen = Math.max(maxLen, dp[j]);
                }
            }
            dp[i] = maxLen + 1;
            longestLen = Math.max(longestLen, dp[i]);
        }

        return longestLen;
    }

    public int lengthOfLIS_BST(int[] nums)
    {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums)
        {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0)
            {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len)
            {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args)
    {
        int[] nums2 = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS_BST(nums2));

        int[] nums3 = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS_BST(nums3));

        int[] nums = { -2, -1 };
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS_BST(nums));

    }
}
