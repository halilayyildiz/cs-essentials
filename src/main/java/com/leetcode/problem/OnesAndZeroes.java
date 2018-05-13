package com.leetcode.problem;

public class OnesAndZeroes
{
    public int findMaxForm(String[] strs, int m, int n)
    {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs)
        {
            int[] count = count(str);
            for (int i = m; i >= count[0]; i--)
            {
                for (int j = n; j >= count[1]; j--)
                {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] count(String str)
    {
        int[] res = new int[] { 0, 0 };
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '0')
                res[0]++;
            else
                res[1]++;
        }
        return res;
    }

    public static void main(String[] args)
    {
        String[] strs = { "10", "0001", "111001", "1", "0" };
        System.out.println(new OnesAndZeroes().findMaxForm(strs, 5, 3));

        String[] strs2 = { "10", "0", "1" };
        System.out.println(new OnesAndZeroes().findMaxForm(strs2, 1, 1));

        String[] strs3 = { "0", "1101", "01", "00111", "1", "10010", "0", "0", "00" };
        System.out.println(new OnesAndZeroes().findMaxForm(strs3, 63, 36));

        String[] strs4 = { "0", "1101", "01", "00111", "1", "10010", "0", "0", "00", "1", "11", "0011" };
        System.out.println(new OnesAndZeroes().findMaxForm(strs4, 63, 36));

        String[] strs5 = { "0", "11", "1000", "01", "0", "101", "1", "1", "1", "0", "0", "0", "0", "1", "0", "0110101", "0", "11", "01", "00", "01111", "0011",
                "1", "1000", "0", "11101", "1", "0", "10", "0111" };
        System.out.println(new OnesAndZeroes().findMaxForm(strs5, 9, 80));

    }
}
