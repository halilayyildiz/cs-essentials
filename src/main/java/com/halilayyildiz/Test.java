package com.halilayyildiz;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		int[] result = new Test().maxSlidingWindow(new int[] { 2, 5, 4, 2, 8, 20, 10, 4 }, 4);
		Arrays.stream(result).forEach(x -> System.out.print(x + " "));
	}

	public int[] maxSlidingWindow(int[] nums, int k) {

		if (nums.length == 0 || nums.length < k) {
			return new int[0];
		}

		int[] result = new int[nums.length - k + 1];
		Deque<Integer> deque = new LinkedList<>();

		int i;
		for (i = 0; i < k; i++) {
			while (!deque.isEmpty() && nums[i] >= deque.peekLast()) {
				deque.removeLast();
			}

			deque.addLast(i);
		}

		for (; i < nums.length; i++) {
			result[i - k] = nums[deque.peekFirst()];

			while (!deque.isEmpty() && deque.peekFirst() <= (i - k)) {
				deque.removeFirst();
			}

			while (!deque.isEmpty() && nums[i] >= deque.peekLast()) {
				deque.removeLast();
			}
			deque.addLast(i);
		}
		result[i - k] = nums[deque.peekFirst()];

		return result;
	}

}
