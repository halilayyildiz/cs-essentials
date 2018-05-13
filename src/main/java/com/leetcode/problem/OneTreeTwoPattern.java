package com.leetcode.problem;

import java.util.Stack;

public class OneTreeTwoPattern
{
    public boolean find132pattern_NTWO(int[] nums)
    {
        if (nums.length < 3)
        {
            return false;
        }

        for (int i = 0; i < nums.length - 1; i++)
        {
            int max = nums[i];
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] < nums[j] && nums[j] < max)
                {
                    return true;
                }

                max = Math.max(max, nums[j]);
            }
        }

        return false;
    }

    public boolean find132pattern(int[] nums)
    {
        if (nums.length < 3)
            return false;
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        for (int j = nums.length - 1; j >= 0; j--)
        {
            if (nums[j] > min[j])
            {
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] nums1 = { -2, 1, 2, -2, 1, 2 };
        System.out.println(new OneTreeTwoPattern().find132pattern(nums1));

        int[] nums = { 1, 4, 5, 8, 3 };
        System.out.println(new OneTreeTwoPattern().find132pattern(nums));

        int[] nums2 = { -1, 3, 2, 0 };
        System.out.println(new OneTreeTwoPattern().find132pattern(nums2));

        int[] nums3 = { 1, 4, 8, 0, 2 };
        System.out.println(new OneTreeTwoPattern().find132pattern(nums3));

        int[] nums4 = { 6, 4, 8, 1, 2 };
        System.out.println(new OneTreeTwoPattern().find132pattern(nums4));
    }
}
