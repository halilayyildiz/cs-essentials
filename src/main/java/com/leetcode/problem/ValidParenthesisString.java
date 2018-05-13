package com.leetcode.problem;

public class ValidParenthesisString
{
    public boolean checkValidString(String s)
    {
        int openCount = 0;
        int openStarCount = 0;
        int closeStarCount = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                openCount++;
            }
            else if (s.charAt(i) == ')')
            {
                if (openCount > 0)
                {
                    openCount--;
                }
                else if (openStarCount > 0)
                {
                    openStarCount--;
                    closeStarCount--;
                }
                else
                {
                    return false;
                }
            }
            else if (s.charAt(i) == '*')
            {
                openStarCount++;
                closeStarCount++;
            }

            if (openCount < closeStarCount)
            {
                closeStarCount = openCount;
            }
        }

        if (openCount > 0)
        {
            return closeStarCount - openCount >= 0;
        }
        else
        {
            return openStarCount - openCount >= 0;
        }
    }

    public static void main(String[] args)
    {

        System.out.println(new ValidParenthesisString().checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        System.out.println(new ValidParenthesisString().checkValidString("()"));
        System.out.println(new ValidParenthesisString().checkValidString("(*)"));
        System.out.println(new ValidParenthesisString().checkValidString("(*))"));
        System.out.println(new ValidParenthesisString().checkValidString("(*()"));
        System.out.println(new ValidParenthesisString().checkValidString("((((*))"));
        System.out.println(new ValidParenthesisString().checkValidString("(((()()()())))"));
        System.out.println(new ValidParenthesisString().checkValidString("(((()(*)()())))"));
        System.out.println(new ValidParenthesisString().checkValidString("((*(*)(*)(*)(*)*)))"));
        System.out.println(new ValidParenthesisString().checkValidString("***(*)(*)(*)(*)*)))"));
        System.out.println(new ValidParenthesisString().checkValidString("***)(*)(*)(*)(*)*)))"));
    }
}
