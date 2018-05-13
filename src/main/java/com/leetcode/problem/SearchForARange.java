package com.leetcode.problem;

public class SearchForARange
{
	public int[] searchRange(int[] nums, int target)
	{
		int[] res = { -1, -1 };

		if (nums.length == 0)
		{
			return res;
		}

		int p1 = 0;
		int p2 = nums.length - 1;
		int i = (p1 + p2) / 2;

		while (p1 >= 0 && p2 < nums.length && p1 <= p2)
		{
			int prev = i;

			if (nums[i] > target)
			{
				p2 = i - 1;
				i = (p1 + p2) / 2;
			}
			else if (nums[i] < target)
			{
				p1 = i + 1;
				i = (p1 + p2) / 2;
			}
			else if (nums[i] == target)
			{
				int start = i;
				int end = i;

				for (int j = i; (j >= 0 && nums[i] == nums[j]); j--)
				{
					start = j;
				}
				for (int j = i; (j < nums.length && nums[i] == nums[j]); j++)
				{
					end = j;
				}

				res[0] = start;
				res[1] = end;
				return res;
			}

			if (i == prev)
			{
				break;
			}
		}

		return res;
	}

	public static void main(String[] args)
	{
		int[] res;

		int[] nums0 = { 1, 5 };
		res = new SearchForARange().searchRange(nums0, 4);
		System.out.println(res[0] + " " + res[1]);

		int[] nums1 = { 1, 4 };
		res = new SearchForARange().searchRange(nums1, 4);
		System.out.println(res[0] + " " + res[1]);

		int[] nums2 = { 5, 7, 7, 8, 8, 10 };
		res = new SearchForARange().searchRange(nums2, 8);
		System.out.println(res[0] + " " + res[1]);
	}
}
