package com.leetcode.problem;

public class StringtoInteger
{
    public int myAtoi(String str)
    {
        if (str == null || str.length() == 0)
        {
            return 0;
        }

        str = str.trim();
        for (int i = 0; i < str.length(); i++)
        {
            if ((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '+' || str.charAt(i) == '-')
            {
                continue;
            }
            else
            {
                str = str.substring(0, i);
                break;
            }
        }
        long result = 0;
        long mult = 1;
        for (int i = str.length() - 1; i >= 0; i--)
        {
            if (str.charAt(i) >= +'0' && str.charAt(i) <= '9')
            {
                result += mult * (str.charAt(i) - '0');
                if (result > Integer.MAX_VALUE)
                {
                    return (str.charAt(0) == '-') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                mult *= 10;
            }
            else if (i == 0 && str.charAt(i) == '-')
            {
                result = -1 * result;
            }
            else if (i == 0 && str.charAt(i) == '+')
            {
                // do nothing
            }
            else
            {
                return 0;
            }
        }

        return (int) result;
    }

    public static void main(String[] args)
    {
        System.out.println(new StringtoInteger().myAtoi("-9223372036854775809"));
        System.out.println(new StringtoInteger().myAtoi("    10522545459"));
        System.out.println(new StringtoInteger().myAtoi("  -0012a42"));
        System.out.println(new StringtoInteger().myAtoi("-10340"));
        System.out.println(new StringtoInteger().myAtoi("+"));
        System.out.println(new StringtoInteger().myAtoi("+-2"));
        System.out.println(new StringtoInteger().myAtoi("    010"));
    }
}
