package com.leetcode.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateII
{
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        if (nums.length < 2 || k < 0)
        {
            return false;
        }

        Map<Integer, List<Integer>> valsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (valsMap.get(nums[i]) == null)
            {
                valsMap.put(nums[i], new ArrayList<Integer>());
            }
            valsMap.get(nums[i]).add(i);
        }

        for (List<Integer> vals : valsMap.values())
        {
            Collections.sort(vals);
            for (int i = 0; i < vals.size() - 1; i++)
            {
                if (vals.get(i + 1) - vals.get(i) <= k)
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}
