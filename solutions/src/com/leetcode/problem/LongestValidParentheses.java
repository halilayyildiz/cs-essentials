package com.leetcode.problem;

import java.util.Stack;

public class LongestValidParentheses
{
	public int longestValidParentheses(String s)
	{
		Stack<Character> stack = new Stack<Character>();

		s = ')' + s + '(';

		int maxLenght = 0;
		int actLenght = 0;
		int preTotal = 0;
		int firstIter = 2;
		Character preChar = ')';

		for (int i = 0; i < s.length(); i++)
		{
			if (preChar == ')' && s.charAt(i) == '(')
			{
				if (stack.isEmpty() || firstIter > 0)
				{
					maxLenght += preTotal;
					preTotal = maxLenght;
					firstIter--;
				}
			}

			if (s.charAt(i) == '(')
			{
				actLenght = 0;
				stack.push(s.charAt(i));
			}

			if (s.charAt(i) == ')')
			{
				if (stack.isEmpty())
				{
					actLenght = 0;
					preTotal = 0;
				}
				else
				{
					Character item = stack.pop();
					if (item != null)
					{
						actLenght++;
						maxLenght = Math.max(actLenght, maxLenght);
					}
					// if (stack.isEmpty())
					// {
					// maxLenght += preTotal;
					// preTotal = maxLenght;
					// }
				}
			}

			preChar = s.charAt(i);
		}

		System.out.println("Len: " + maxLenght * 2);
		return maxLenght * 2;
	}

	public static void main(String[] args)
	{
		// String input = ")()())";
		// String input = ")(())(((())))))((";
		// String input = "(()()";
		// String input = "()(()";
		String input = "(()())";

		new LongestValidParentheses().longestValidParentheses(input);
	}

}
