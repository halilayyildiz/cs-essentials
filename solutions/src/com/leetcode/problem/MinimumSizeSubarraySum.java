package com.leetcode.problem;

public class MinimumSizeSubarraySum
{
    public int minSubArrayLen(int s, int[] nums)
    {
        if(nums.length == 0)
        {
            return 0;
        }
        
        int minCount = nums.length+1;
        int start = 0;
        int end= 0;
        int sum = nums[0];
        int count = 1;
        
        while (true)
        {
            if(sum < s)
            {
                if(end == nums.length-1)
                {
                    break;
                }
                
                end++;
                count++;
                sum += nums[end];
            }
            else
            {
                minCount = count < minCount ? count : minCount;
                
                sum -= nums[start];
                start++;
                count--;
            }
        }
        
        return minCount <= nums.length ? minCount : 0;
    }
    
    public static void main(String[] args)
    {
        int s = 15;
        int[] nums = {1,2,3,4,5};
        new MinimumSizeSubarraySum().minSubArrayLen(s, nums);
    }
}
