package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges
{

    public List<String> summaryRanges(int[] nums)
    {
        List<String> result = new ArrayList<>();

        if (nums.length == 0)
        {
            return new ArrayList<>();
        }

        int startIdx = 0;
        int endIdx = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (startIdx != i)
            {
                if (nums[i] != nums[i - 1] + 1)
                {
                    if (startIdx == endIdx)
                    {
                        result.add(nums[startIdx] + "");
                    }
                    else
                    {
                        result.add(nums[startIdx] + "->" + nums[endIdx]);
                    }
                    startIdx = i;
                    endIdx = i;
                }
                else
                {
                    endIdx = i;
                }
            }

            if (i == nums.length - 1)
            {
                if (startIdx == endIdx)
                {
                    result.add(nums[startIdx] + "");
                }
                else
                {
                    result.add(nums[startIdx] + "->" + nums[endIdx]);
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums1 = { 0, 1, 2, 4, 5, 7 };
        int[] nums2 = { 0, 2, 3, 4, 6, 8, 9 };
        int[] nums3 = { 0 };
        System.out.println(new SummaryRanges().summaryRanges(nums1));
        System.out.println(new SummaryRanges().summaryRanges(nums2));
        System.out.println(new SummaryRanges().summaryRanges(nums3));
    }

}
