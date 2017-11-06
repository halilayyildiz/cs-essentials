package com.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum
{

    public List<List<Integer>> threeSum(int[] nums)
    {
        final int length = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, int[]> hashMap = new HashMap<Integer, int[]>();

        // if length is less than 3, return empty result set
        if (length < 3)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i < length - 2; i++)
        {
            if (nums[i] > 0)
                break;
            hashMap.clear();

            if (i == 0 || nums[i] > nums[i - 1])
            {
                for (int j = i + 1; j < length; j++)
                {
                    if (hashMap.containsKey(nums[j]))
                    { // found target
                        ArrayList<Integer> elem = new ArrayList<Integer>(3);

                        elem.add(hashMap.get(nums[j])[0]);
                        elem.add(hashMap.get(nums[j])[1]);
                        elem.add(nums[j]);

                        result.add(elem);

                        // remove duplicated elements
                        while (j < (length - 1) && nums[j] == nums[j + 1])
                            j++;
                    }
                    else
                    {
                        int[] temp = new int[2];
                        temp[0] = nums[i];
                        temp[1] = nums[j];
                        hashMap.put(0 - (nums[i] + nums[j]), temp);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> threeSum = new ThreeSum().threeSum(nums);
        for (List<Integer> list : threeSum)
        {
            for (Integer item : list)
            {
                System.out.print(item + " ");
            }
            System.out.println("");
        }
    }

}
