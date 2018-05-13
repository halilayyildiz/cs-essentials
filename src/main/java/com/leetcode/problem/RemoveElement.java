package com.leetcode.problem;

public class RemoveElement
{

	public int removeElement(int[] nums, int val)
	{
		int gapSize = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if(i == nums.length-1)
			{
				if(nums[i] == val)
				{
					gapSize++;
				}
				else
				{
					nums[i - gapSize] = nums[i];
				}
				break;
			}
			
			
			if (nums[i] == val)
			{
				if (i + 1 < nums.length)
				{
					while (i != nums.length-1 && nums[i + 1] == val)
					{
						i++;
						gapSize++;
					}
					
					if(i == nums.length-1)
					{
						nums[i - gapSize] = nums[i];
						gapSize++;
						break;
					}

					nums[i - gapSize] = nums[i + 1];
				}
				
				gapSize++;
			}
			else
			{
				nums[i - gapSize] = nums[i];
			}
		}

		return nums.length - gapSize;
	}

	public static void main(String[] args)
	{
		int[] input = { 1,2,3,4 };
		new RemoveElement().removeElement(input, 1);
	}
}
