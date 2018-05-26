package com.leetcode.problem;

public class WiggleSubsequence
{
    public int wiggleMaxLength(int[] nums)
    {
        if (nums.length < 2)
        {
            return nums.length;
        }

        int max = 1;
        int ptr = 0;
        int diff = 0;

        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] != nums[i - 1])
            {
                max++;
                diff = nums[i] - nums[i - 1];
                ptr = i;
                break;
            }
        }

        for (int i = ptr + 1; i < nums.length; i++)
        {
            if ((nums[i] - nums[ptr]) * diff < 0)
            {
                diff = nums[i] - nums[ptr];
                max++;
            }
            ptr = i;
        }

        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(new WiggleSubsequence().wiggleMaxLength(new int[] { 1, 7, 4, 9, 2, 5 })); // 6
        System.out.println(new WiggleSubsequence().wiggleMaxLength(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 })); // 7
        System.out.println(new WiggleSubsequence().wiggleMaxLength(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 })); // 2
    }
}
