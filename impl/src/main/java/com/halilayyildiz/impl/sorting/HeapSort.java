package com.halilayyildiz.impl.sorting;

import java.util.PriorityQueue;

public class HeapSort {

    public void sortArray(int[] nums) {
        if (nums.length < 2) return;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = pq.poll();
        }
    }
}