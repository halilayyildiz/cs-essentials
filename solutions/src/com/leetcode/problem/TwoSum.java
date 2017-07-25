package com.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum
{

	public static int[] twoSum(int[] nums, int target) 
	{
        int[] result = null;
        int[] numsCopy = new int[nums.length];
        List<Integer> resultList = new ArrayList<Integer>();
        
        System.arraycopy( nums, 0, numsCopy, 0, nums.length );
		Arrays.sort(numsCopy);
		int maxVal = numsCopy[numsCopy.length - 1];
		
		int[] valTable = new int[maxVal+1];
		for (int i = 0; i < valTable.length; i++)
		{
			valTable[i] = Integer.MIN_VALUE;
		}
		
		for (int i = 0; i < nums.length; i++)
		{
			int val = nums[i];
			
			if((target-val > 0 && target-val < maxVal) && valTable[target-val] != Integer.MIN_VALUE)
			{
				resultList.add(valTable[target-val]);
				resultList.add(i);
				
				valTable[target-val] = Integer.MIN_VALUE;
			}
			else
			{
				valTable[val] = i;
			}
		}
		
		result = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++)
		{
			result[i] = resultList.get(i);
		}
		
		return result;
    }
	
	public static void main(String[] args)
	{
//		Scanner scanner = new Scanner(System. in); 
//		String input1 = scanner. nextLine();
		
		int[] nums = {3,2,4};
		int target = 6;
		
		twoSum(nums, target);
	}

}
