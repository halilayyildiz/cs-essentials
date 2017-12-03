package com.leetcode.problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum
{
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        if (nums.length == 0 || nums.length < k)
        {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++)
        {
            maxHeap.add(nums[i]);
        }
        result[0] = maxHeap.peek();

        for (int i = k; i < nums.length; i++)
        {
            maxHeap.remove(nums[i - k]);
            maxHeap.add(nums[i]);
            result[i - k + 1] = maxHeap.peek();
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        Arrays.stream(new SlidingWindowMaximum().maxSlidingWindow(nums, 3)).forEach(i -> System.out.println(i + ""));
    }
}
