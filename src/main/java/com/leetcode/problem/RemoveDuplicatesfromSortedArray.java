package com.leetcode.problem;

public class RemoveDuplicatesfromSortedArray
{
	public int removeDuplicates(int[] nums)
	{
		if (nums.length == 0)
		{
			return 0;
		}

		int before = nums[0];
		int count = 1;
		int windowSize = 0;
		for (int i = 1; i < nums.length; i++)
		{
			while(before == nums[i])
			{
				before = nums[i];
				i++;
				windowSize++;
				if(i >= nums.length)
				{
					break;
				}
			}
			
			if(i == nums.length)
			{
				break;
			}
			
			if(before != nums[i])
			{
				count++;
				before = nums[i];
				nums[i-windowSize] = nums[i];
			}
		}

		System.out.println(count);
		return count;
	}

	public static void main(String[] args)
	{
//		int[] nums = {1,2,3,4,5,5,5,6,7,9};
		int[] nums2 = {1,2,3};
		new RemoveDuplicatesfromSortedArray().removeDuplicates(nums2);
	}

}
