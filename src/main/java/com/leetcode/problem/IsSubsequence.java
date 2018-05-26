package com.leetcode.problem;

// Problem 319

public class IsSubsequence
{
    public boolean isSubsequence(String s, String t)
    {

        if (s == null || s.length() == 0)
        {
            return true;
        }

        int ptr = 0;
        for (int i = 0; i < t.length(); i++)
        {
            if (t.charAt(i) == s.charAt(ptr))
            {
                ptr++;
            }
            if (ptr == s.length())
            {
                break;
            }
        }

        return ptr == s.length();
    }

    public static void main(String[] args)
    {
        System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
        System.out.println(new IsSubsequence().isSubsequence("axc", "ahbgdc"));
    }
}
