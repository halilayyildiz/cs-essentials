package com.leetcode.problem;

public class RemoveNthNodeFromEndofList
{

	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		ListNode temp = head;
		
		int listCount = 1;
		while(temp.next != null)
		{
			listCount++;
			temp = temp.next;
		}
		
		if(listCount == 1 && n == 1)
		{
			return null;
		}
		
		int startFrom = listCount - n;
		
		if(startFrom == 0)
		{
			return head.next;
		}
		
		int index = 1;
		temp = head;
		while(temp != null)
		{
			if(index == startFrom)
			{
				temp.next = temp.next.next;
				break;
			}
			else
			{
				temp = temp.next;
			}
			
			index++;
			if(temp.next == null)
			{
				break;
			}
		}
		
		return head;
	}

	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		
		new RemoveNthNodeFromEndofList().removeNthFromEnd(head, 2);
	}
}
