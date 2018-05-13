package com.leetcode.problem;

public class NumberOfDigitOne
{

    public int countDigitOne(int n)
    {
        long num1s = 0;
        for (int i = 0; i < 32; i++)
        {// for each digit
            long div = (long) Math.pow(10, i);
            if (div > n)
                break;
            num1s += n / (div * 10) * div + helper(n % (div * 10), div);
        }
        return (int) num1s;
    }

    private long helper(long x, long powerOf10)
    {// get the number of 1s at x's first digit (x/powerOf10 < 10)
        long res = x / powerOf10;
        if (res == 0)
            return 0;
        if (res > 1)
            return powerOf10;
        return x - res * powerOf10 + 1; // for case x = 10,
    }

    public static void main(String[] args)
    {

        // System.out.println(new NumberOfDigitOne().countDigitOne(1));
        System.out.println(new NumberOfDigitOne().countDigitOne(11));
        System.out.println(new NumberOfDigitOne().countDigitOne(12));
        System.out.println(new NumberOfDigitOne().countDigitOne(13));
        System.out.println(new NumberOfDigitOne().countDigitOne(99));
        System.out.println(new NumberOfDigitOne().countDigitOne(100));
        System.out.println(new NumberOfDigitOne().countDigitOne(115));
        System.out.println(new NumberOfDigitOne().countDigitOne(405));
    }

}
