package com.halilayyildiz;

public class BinarySearch{

    public static void main(String[] args){
        int res = new BinarySearch().search(new int[]{
            0,1,2,3,4,5,6,7},
            2);
        System.out.println("res: " + res);
    }

    public int search(int[] nums, int target) 
    {
        int lo = 0;
        int hi = nums.length - 1;
    
        while(lo <= hi)
        {
            System.out.println(lo + " " + hi);

            int mid = (lo + hi) >>> 1;
    
            if(nums[mid] < target)
                lo = mid + 1;
            else if(nums[mid] > target)
                hi = mid - 1;
            else
                return mid;
        }
    
        return -1;
    }

}

