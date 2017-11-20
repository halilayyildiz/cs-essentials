package com.leetcode.problem;

import java.util.Arrays;

public class HIndex
{
	public int hIndex(int[] citations)
	{
		int res = 0;

		if (citations.length == 0)
		{
			return res;
		}

		Arrays.sort(citations);

		int last = citations.length - 1;
		for (int i = 0; i < citations.length; i++)
		{
			if (citations[last - i] >= i + 1)
			{
				res = Math.max(res, i + 1);
			}
		}

		return res;
	}

	public static void main(String[] args)
	{
		int[] citations = { 3, 0, 6, 1, 5 };
		System.out.println(new HIndex().hIndex(citations));

		int[] citations2 = { 7, 4, 6, 1, 5 };
		System.out.println(new HIndex().hIndex(citations2));

		int[] citations3 = { 100 };
		System.out.println(new HIndex().hIndex(citations3));
	}
}
