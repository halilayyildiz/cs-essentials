package com.leetcode.problem;

public class ContainerWithMostWater
{

	public int maxArea(int[] height)
	{
		int i = 0;
		int j = height.length - 1;
		int ans = 0;
		int area, mini;
	    
		while(i < j) {
			
	        mini = Math.min(height[i], height[j]);
	        area = (j - i) * mini;
	        ans = Math.max(area, ans);
	        if(height[i] > height[j]) j--;
	        else i++;
		}
		
		return ans;
	}

	public static void main(String[] args)
	{
		int[] input = { 1, 5, 4, 3 };
		new ContainerWithMostWater().maxArea(input);
	}
	
}
