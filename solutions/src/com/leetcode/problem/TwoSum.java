package com.leetcode.problem;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwoSum
{

	public static int[] twoSum(int[] nums, int target)
	{
		int[] result = null;
		List<Integer> resultList = new ArrayList<Integer>();
		List<SimpleEntry<Integer, Integer>> numsEntryList = new ArrayList<SimpleEntry<Integer, Integer>>();

		for (int i = 0; i < nums.length; i++)
		{
			numsEntryList.add(new SimpleEntry<Integer, Integer>(nums[i], i));
		}

		Collections.sort(numsEntryList, new Comparator<SimpleEntry<Integer, Integer>>() {

			@Override
			public int compare(SimpleEntry<Integer, Integer> o1, SimpleEntry<Integer, Integer> o2)
			{
				return o1.getKey().compareTo(o2.getKey());
			}
		});

		for (int i = 0, j = numsEntryList.size() - 1; i < numsEntryList.size();)
		{
			if (i >= j)
			{
				break;
			}

			if (numsEntryList.get(i).getKey() + numsEntryList.get(j).getKey() > target)
			{
				j--;
				continue;
			}
			else if (numsEntryList.get(i).getKey() + numsEntryList.get(j).getKey() < target)
			{
				i++;
				continue;
			}
			else if (numsEntryList.get(i).getKey() + numsEntryList.get(j).getKey() == target)
			{
				resultList.add(numsEntryList.get(i).getValue());
				resultList.add(numsEntryList.get(j).getValue());

				i++;
				j--;
			}
		}

		result = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++)
		{
			result[i] = resultList.get(i);
		}

		return result;
	}

	public static void main(String[] args)
	{
		// Scanner scanner = new Scanner(System. in);
		// String input1 = scanner. nextLine();

		int[] nums = { 2, 5, 5, 11 };
		int target = 10;

		twoSum(nums, target);
	}

}
