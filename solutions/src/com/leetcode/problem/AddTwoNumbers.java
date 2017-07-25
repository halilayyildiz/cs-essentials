package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers
{
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode result = null;
		int maxListSize = 0;
		
		List<Integer> number1 = new ArrayList<Integer>();
		List<Integer> number2 = new ArrayList<Integer>();
		List<Integer> resultList = new ArrayList<Integer>();
		
		ListNode refNode = l1;
		while(refNode.next != null)
		{
			number1.add(refNode.val);
			refNode = refNode.next;
		}
		number1.add(refNode.val);
		
		refNode = l2;
		while(refNode.next != null)
		{
			number2.add(refNode.val);
			refNode = refNode.next;
		}
		number2.add(refNode.val);
			
		maxListSize = number1.size() > number2.size() ? number1.size() : number2.size();
		int size = maxListSize - number1.size();
		for (int i = 0; i < size; i++)
		{
			number1.add(0);
		}
		size = maxListSize - number2.size();
		for (int i = 0; i < size; i++)
		{
			number2.add(0);
		}

		int extra = 0;
		for (int i = 0; i < number1.size(); i++)
		{
			int sum = number1.get(i) + number2.get(i) + extra;
			
			resultList.add(sum % 10);
			extra = sum / 10;
		}
		if(extra > 0)
		{
			resultList.add(extra);
		}
		
		
		refNode = new ListNode(resultList.get(0));
		result = refNode;
		for (int i = 1; i < resultList.size(); i++)
		{
			refNode.next = new ListNode(resultList.get(i));
			refNode = refNode.next;
		}
		
		return result;
	}
	
	
	public static void main(String[] args)
	{
		ListNode listNode1 = new ListNode(9);
		listNode1.next = new ListNode(9);
		listNode1.next.next = new ListNode(9);
		listNode1.next.next.next = new ListNode(9);
		listNode1.next.next.next.next = new ListNode(9);
		
		ListNode listNode2 = new ListNode(1);
//		listNode2.next = new ListNode(6);
//		listNode2.next.next = new ListNode(4);
//		listNode2.next.next.next = new ListNode(9);
//		listNode2.next.next.next.next = new ListNode(9);
//		listNode2.next.next.next.next.next = new ListNode(9);
//		listNode2.next.next.next.next.next.next = new ListNode(9);
//		listNode2.next.next.next.next.next.next.next = new ListNode(9);
//		listNode2.next.next.next.next.next.next.next.next = new ListNode(9);
//		listNode2.next.next.next.next.next.next.next.next.next = new ListNode(9);
		
		
		addTwoNumbers(listNode1,listNode2);
		
	}
}
