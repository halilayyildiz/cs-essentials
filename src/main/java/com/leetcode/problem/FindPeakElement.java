package com.leetcode.problem;

public class FindPeakElement
{
    public int findPeakElement(int[] nums)
    {
        if (nums.length == 1)
        {
            return 0;
        }
        if (nums.length == 2)
        {
            if (nums[0] > nums[1])
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
        return findPeakElement(nums, 0, nums.length);
    }

    public int findPeakElement(int[] nums, int start, int end)
    {
        int med = (end + start) / 2;

        if (med - 1 >= 0 && med + 1 < nums.length && nums[med] > nums[med - 1] && nums[med] > nums[med + 1])
        {
            return med;
        }

        if (med - 1 < 0 && med + 1 < nums.length && nums[med] > nums[med + 1])
        {
            return med;
        }

        if (med - 1 >= 0 && med + 1 >= nums.length && nums[med] > nums[med - 1])
        {
            return med;
        }

        if (nums[med + 1] > nums[med - 1])
        {
            return findPeakElement(nums, med, end);
        }
        else
        {
            return findPeakElement(nums, 0, med);
        }
    }

    public static void main(String[] args)
    {
        int[] nums = { 2, 1 };
        int peakElement = new FindPeakElement().findPeakElement(nums);
        System.out.println("Peak Elem:" + nums[peakElement]);
    }

}
