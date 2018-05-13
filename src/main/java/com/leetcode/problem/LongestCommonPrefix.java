package com.leetcode.problem;

public class LongestCommonPrefix
{
	public String longestCommonPrefix(String[] strs)
	{
		int maxIndex = 0;
		
		if(strs.length == 0)
		{
			return "";
		}
		if(strs.length == 1)
		{
			return strs[0];
		}
		
		for (int max=0, i = 0; i < strs.length; i++)
		{
			if(strs[i].length() > max)
			{
				max = strs[i].length();
				maxIndex = i;
			}
		}

		int i = 0, end = 0;
		String refr = strs[maxIndex];
		boolean isSame = true;
		while(isSame)
		{
			isSame = true;
			for (int j = 0; j < strs.length; j++)
			{
				if (i >= strs[j].length() || strs[j].charAt(i) != refr.charAt(i))
				{
					isSame = false;
					end = i;
					break;
				}
			}
			
			i++;
		}
		
		String result = refr.substring(0, end);
		System.out.println(result);
		
		return result;
	}

	public static void main(String[] args)
	{
//		String[] arry1 = { "abcd", "abckdefsd", "abc", "abcdsdsdef", "abcddddef" };
		String[] arry2 = { "", "b" };
		new LongestCommonPrefix().longestCommonPrefix(arry2);
	}

}
