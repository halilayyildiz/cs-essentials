package com.leetcode.problem;

import java.util.Stack;

public class LongestValidParentheses
{
    public int longestValidParentheses(String s)
    {
        int maxLen = 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                stack.push(i);
            }
            else
            {
                stack.pop();
                if (!stack.isEmpty())
                {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
                else
                {
                    stack.push(i);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args)
    {
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()()")); // 4
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())()()(")); // 4
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()(()()(()))")); // 12
        System.out.println(new LongestValidParentheses().longestValidParentheses("()(()")); // 2
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()(((()")); // 2
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()(((()")); // 2
        System.out.println(new LongestValidParentheses().longestValidParentheses("()")); // 2
    }

}
