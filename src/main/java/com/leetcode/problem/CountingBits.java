package com.leetcode.problem;

import java.util.Arrays;

public class CountingBits
{

    // O(n*sizeof(integer)).
    public int[] countBits(int num)
    {
        int[] bits = new int[num + 1];

        for (int i = 0; i <= num; i++)
        {
            String s = Integer.toBinaryString(i);

            for (int j = 0; j < s.length(); j++)
            {
                bits[i] += (s.charAt(j) - '0');
            }
        }

        return bits;
    }

    // O(n)
    public int[] countBits2(int num)
    {
        int[] result = new int[num + 1];

        int p = 1; // p tracks the index for number x
        int pow = 1;
        for (int i = 1; i <= num; i++)
        {
            if (i == pow)
            {
                result[i] = 1;
                pow <<= 1;
                p = 1;
            }
            else
            {
                result[i] = result[p] + 1;
                p++;
            }

        }

        return result;
    }

    public static void main(String[] args)
    {

        Arrays.stream(new CountingBits().countBits2(20)).forEach(num -> System.out.print(num + " "));
    }
}
