package com.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations
{
    private void nextPermutation(int[] nums)
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

    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();

        List<Integer> numList = new ArrayList<>();
        int[] origNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            numList.add(nums[i]);
            origNums[i] = nums[i];
        }

        while (true)
        {
            nextPermutation(nums);
            numList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++)
            {
                numList.add(nums[i]);
            }
            permutations.add(numList);

            if (Arrays.equals(nums, origNums))
            {
                break;
            }
        }

        return permutations;
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 3, 4 };
        List<List<Integer>> permutations = new Permutations().permute(nums);
        permutations.stream().forEach(list -> System.out.println(list));
    }
}
