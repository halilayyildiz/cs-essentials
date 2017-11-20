package com.leetcode.problem;

public class Candy
{
	public int candy(int[] ratings)
	{
		if (ratings.length == 1)
		{
			return 1;
		}

		int[] left = new int[ratings.length];
		int[] right = new int[ratings.length];
		int last = ratings.length - 1;
		int res = 0;

		left[0] = 1;
		for (int i = 1; i < ratings.length; i++)
		{
			if (ratings[i - 1] < ratings[i])
			{
				left[i] = left[i - 1] + 1;
			}
			else
			{
				left[i] = 1;
			}
		}

		right[last] = 1;
		for (int i = last - 1; i >= 0; i--)
		{
			if (ratings[i] > ratings[i + 1])
			{
				right[i] = right[i + 1] + 1;
			}
			else
			{
				right[i] = 1;
			}
		}

		for (int i = 0; i < ratings.length; i++)
		{
			res += Math.max(left[i], right[i]);
		}

		return res;
	}

	public static void main(String[] args)
	{
		int[] ratings = { 2, 2 };
		System.out.println(new Candy().candy(ratings));
	}
}
