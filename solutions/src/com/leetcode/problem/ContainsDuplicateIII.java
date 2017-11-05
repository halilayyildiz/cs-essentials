package com.leetcode.problem;

import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicateIII
{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        if (nums == null || nums.length < 2 || k < 0 || t < 0)
        {
            return false;
        }

        SortedSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++)
        {
            long val = (long) nums[i];
            long minVal = val - t;
            long maxval = val + t + 1;

            SortedSet<Long> subSet = set.subSet(minVal, maxval);
            if (!subSet.isEmpty())
            {
                return true;
            }

            set.add(val);
            if (set.size() >= k + 1)
            {
                set.remove((long) nums[i - k]);
            }

        }

        return false;
    }

    public static void main(String[] args)
    {
        int[] nums = { -1, 2147483647 };
        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }

}
