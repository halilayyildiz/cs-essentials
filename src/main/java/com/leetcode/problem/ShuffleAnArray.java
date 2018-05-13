package com.leetcode.problem;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ShuffleAnArray
{
    private int[] nums;
    private int[] shuffle;

    public void nextPermutation(int[] nums)
    {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i])
        {
            i--;
        }
        if (i >= 0)
        {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i])
            {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start)
    {
        int i = start, j = nums.length - 1;
        while (i < j)
        {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public ShuffleAnArray(int[] nums)
    {
        this.nums = nums;
        this.shuffle = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            shuffle[i] = nums[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset()
    {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle()
    {
        if (nums.length < 2)
        {
            return nums;
        }

        nextPermutation(shuffle);
        return shuffle;
    }

    public static void main(String[] args)
    {
        int[] input = { -6, 10, 184 };
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(input);

        System.out.println(Arrays.stream(shuffleAnArray.shuffle()).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(shuffleAnArray.shuffle()).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(shuffleAnArray.shuffle()).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(shuffleAnArray.shuffle()).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(shuffleAnArray.shuffle()).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(shuffleAnArray.shuffle()).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(shuffleAnArray.shuffle()).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(shuffleAnArray.shuffle()).boxed().collect(Collectors.toList()));
    }

}
