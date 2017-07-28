package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class LongestValidParentheses
{
	public int longestValidParentheses(String s)
	{
		Stack<Character> stackOpen = new Stack<Character>();

		int maxLenght = 0;
		int actLenght = 0;
		Character preChar = null;
		int lastStackLevel = Integer.MAX_VALUE;
		List<Integer> parLens = new ArrayList<Integer>();

		for (int i = 0; i < s.length(); i++)
		{
			if (preChar != null && preChar == ')' && s.charAt(i) == '(')
			{
				if (actLenght > 0 && (stackOpen.size() <= lastStackLevel))
				{
					parLens.add(actLenght);
					actLenght = 0;
					lastStackLevel = Math.min(stackOpen.size(), lastStackLevel);
				}

				Integer sum = parLens.stream().collect(Collectors.summingInt(Integer::intValue));
				if (actLenght > 0 && (stackOpen.size() > lastStackLevel) && (sum < actLenght))
				{
					parLens.clear();
					parLens.add(actLenght);
					actLenght = 0;
					lastStackLevel = stackOpen.size();
				}
			}

			if (s.charAt(i) == '(')
			{
				stackOpen.push(s.charAt(i));
			}

			if (s.charAt(i) == ')')
			{
				if (stackOpen.isEmpty())
				{
					parLens.add(actLenght);
					Integer sum = parLens.stream().collect(Collectors.summingInt(Integer::intValue));
					maxLenght = Math.max(sum, maxLenght);
					actLenght = 0;
					parLens.clear();
				}
				else
				{
					Character item = stackOpen.pop();
					if (item != null)
					{
						actLenght++;
					}
					else
					{
						Integer sum = parLens.stream().collect(Collectors.summingInt(Integer::intValue));
						maxLenght = Math.max(sum, maxLenght);
						parLens.clear();
					}

				}
			}

			if (i == s.length() - 1)
			{
				if (actLenght > 0 && (stackOpen.size() <= lastStackLevel))
				{
					parLens.add(actLenght);
				}

				Integer sum = parLens.stream().collect(Collectors.summingInt(Integer::intValue));
				if (actLenght > 0 && (stackOpen.size() > lastStackLevel) && (sum < actLenght))
				{
					parLens.clear();
					parLens.add(actLenght);
					actLenght = 0;
					lastStackLevel = stackOpen.size();
				}
			}

			preChar = s.charAt(i);
		}

		Integer sum = parLens.stream().collect(Collectors.summingInt(Integer::intValue));
		maxLenght = Math.max(sum, maxLenght);
		parLens.clear();

		System.out.println("Len: " + maxLenght * 2);
		return maxLenght * 2;
	}

	public static void main(String[] args)
	{
		// String input = ")()())";
		// String input = ")(())(((())))))((";
		String input1 = "(()()"; // 4
		String input2 = "()(()"; // 2
		String input3 = "(()(((()"; // 2
		String input4 = "()(()(((";
		String input5 = ")(((((()())()()))()(()))("; // 22
		String input6 = "((()))())"; // 8
		String input7 = ")()())()()("; // 4
		String input8 = "()((())()"; // 6
		String input9 = ")(()((((())";
		String input10 = ")()(()()(()))";

		// String input = "()())((";
		// String input = "(()())";
		// String input = "(()";
		// String input = "(()(((()";

		LongestValidParentheses obj = new LongestValidParentheses();
		// obj.longestValidParentheses(input1); // 4
		// obj.longestValidParentheses(input2); // 2
		// obj.longestValidParentheses(input3); // 2
		// obj.longestValidParentheses(input4); // 2
		// obj.longestValidParentheses(input5); // 22
		// obj.longestValidParentheses(input6); // 8
		// obj.longestValidParentheses(input7); // 4
		// obj.longestValidParentheses(input8); // 6
		// obj.longestValidParentheses(input9); // 4
		obj.longestValidParentheses(input10); // 12
	}

}
