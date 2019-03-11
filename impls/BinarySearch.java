package com.halilayyildiz;

public class BinarySearch{

    public static void main(String[] args){
        System.out.println("res: " + new BinarySearch().search(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12},2));
        System.out.println("res: " + new BinarySearch().search(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12},-1));
        System.out.println("res: " + new BinarySearch().search(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12},-2));
        System.out.println("res: " + new BinarySearch().search(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12},12));
        System.out.println("res: " + new BinarySearch().search(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12},6));   
    }

    public int search(int[] nums, int target) 
    {
        int start = 0;
        int end = nums.length - 1;
    
        while(start <= end)
        {
            int mid = (start + end) / 2;
    
            if(nums[mid] < target)
                start = mid + 1;
            else if(nums[mid] > target)
                end = mid - 1;
            else
                return mid;
        }
    
        return -1;
    }
}

