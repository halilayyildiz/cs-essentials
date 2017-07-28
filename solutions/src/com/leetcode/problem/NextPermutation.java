package com.leetcode.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutation
{

	public void nextPermutation(int[] nums)
	{
		if (nums.length > 1)
		{
			boolean found = false;
			for (int i = nums.length - 1; i > 0; i--)
			{
				if (nums[i] > nums[i - 1])
				{
					int refVal = nums[i - 1];
					int minGreaterIndex = i - 1;
					
					int maxVal = refVal;
					for (int j = i - 1; j < nums.length; j++)
					{
						if(nums[j] > maxVal)
						{
							maxVal = nums[j];
							minGreaterIndex = j;
						}
					}
					
					for (int j = i - 1; j < nums.length; j++)
					{
						if (nums[j] > refVal && nums[j] <= nums[minGreaterIndex])
						{
							minGreaterIndex = j;
						}
					}

					int temp = nums[i - 1];
					nums[i - 1] = nums[minGreaterIndex];
					nums[minGreaterIndex] = temp;
					found = true;

					List<Integer> tmpList = new ArrayList<Integer>();
					for (int j = i; j < nums.length; j++)
					{
						tmpList.add(nums[j]);
					}
					Collections.sort(tmpList);

					for (int j = i, k = 0; j < nums.length; j++, k++)
					{
						nums[j] = tmpList.get(k);
					}

					break;
				}
			}

			if (!found)
			{
				int[] tempArr = new int[nums.length];
				for (int i = 0; i < nums.length; i++)
				{
					tempArr[tempArr.length - i - 1] = nums[i];
				}
				
				for (int i = 0; i < tempArr.length; i++)
				{
					nums[i] = tempArr[i];
				}
			}
		}
	}

	public static void main(String[] args)
	{
//		int[] nums = { 5, 3, 8, 6, 4, 2, 1 };
		int[] nums = { 3, 2, 1 };
		new NextPermutation().nextPermutation(nums);
	}

}
