package com.leetcode.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class InterleavingString
{
	class Pair
	{
		int s1, s2;

		public Pair(int s1, int s2)
		{
			this.s1 = s1;
			this.s2 = s2;
		}

		@Override
		public boolean equals(Object obj)
		{
			Pair other = (Pair) obj;
			return this.s1 == other.s1 && this.s2 == other.s2;
		}

		@Override
		public int hashCode()
		{
			return Objects.hash(this.s1, this.s2);
		}

	}

	public boolean isInterleave(String s1, String s2, String s3)
	{

		List<Pair> list = new ArrayList<>();
		list.add(new Pair(0, 0));

		for (int i = 0; i < s3.length(); i++)
		{
			Set<Pair> temp = new HashSet<>();
			for (int j = 0; j < list.size(); j++)
			{
				Pair pair = list.get(j);

				if ((pair.s1) < s1.length() && s3.charAt(i) == s1.charAt(pair.s1))
				{
					temp.add(new Pair(pair.s1 + 1, pair.s2));
				}

				if ((pair.s2) < s2.length() && s3.charAt(i) == s2.charAt(pair.s2))
				{
					temp.add(new Pair(pair.s1, pair.s2 + 1));
				}
			}
			list = new ArrayList<>(temp);
		}
		
		for (Pair pair : list)
		{
			if (pair.s1 == s1.length() && pair.s2 == s2.length())
			{
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
}
