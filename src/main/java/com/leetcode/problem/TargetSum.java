package com.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

public class TargetSum
{
    public int findTargetSumWays(int[] nums, int S)
    {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++)
        {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int key : map.keySet())
            {
                if (!temp.containsKey(key))
                {
                    temp.put(key, 0);
                }

                temp.put(key + nums[i], temp.containsKey(key + nums[i]) ? temp.get(key + nums[i]) + map.get(key) : map.get(key));
                temp.put(key - nums[i], temp.containsKey(key - nums[i]) ? temp.get(key - nums[i]) + map.get(key) : map.get(key));
            }
            map = temp;
        }

        return map.containsKey(S) ? map.get(S) : 0;
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 1, 1, 1, 1 };
        System.out.println(new TargetSum().findTargetSumWays(nums, 3));
    }
}
