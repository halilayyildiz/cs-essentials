package com.halilayyildiz;

import java.util.HashSet;
import java.util.Set;

public class Question2
{
    public int solution(int[][] A)
    {
        if (A.length == 0)
        {
            return 0;
        }

        int[][] dp = new int[A.length][A[0].length];

        for (int i = A.length - 1, count = 0; i >= 0; i--)
        {
            for (int j = A[0].length - 1; j >= 0; j--)
            {
                if (i + 1 < A.length && A[i][j] == A[i + 1][j])
                {
                    dp[i][j] = dp[i + 1][j];
                }
                else if (j + 1 < A[0].length && A[i][j] == A[i][j + 1])
                {
                    dp[i][j] = dp[i][j + 1];
                }
                else
                {
                    count++;
                    dp[i][j] = count;
                }
            }
        }

        int count = 0;
        Set<Integer> countNums = new HashSet<>();
        for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < A[0].length; j++)
            {
                if (i - 1 >= 0 && A[i][j] == A[i - 1][j])
                {
                    if (!countNums.contains(dp[i][j]))
                    {
                        count++;
                        countNums.add(dp[i][j]);
                    }
                }
                else if (j - 1 >= 0 && A[i][j] == A[i][j - 1])
                {
                    if (!countNums.contains(dp[i][j]))
                    {
                        count++;
                        countNums.add(dp[i][j]);
                    }
                }
                else if (i + 1 < A.length && dp[i][j] == dp[i + 1][j])
                {
                    if (!countNums.contains(dp[i][j]))
                    {
                        count++;
                        countNums.add(dp[i][j]);
                    }
                }
                else if (j + 1 < A[0].length && dp[i][j] == dp[i][j + 1])
                {
                    if (!countNums.contains(dp[i][j]))
                    {
                        count++;
                        countNums.add(dp[i][j]);
                    }
                }
                else
                {
                    if (!countNums.contains(dp[i][j]))
                    {
                        count++;
                        countNums.add(dp[i][j]);
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[][] A = new int[7][3];

        A[0][0] = 5;
        A[0][1] = 4;
        A[0][2] = 4;
        A[1][0] = 4;
        A[1][1] = 3;
        A[1][2] = 4;
        A[2][0] = 3;
        A[2][1] = 2;
        A[2][2] = 4;
        A[3][0] = 2;
        A[3][1] = 2;
        A[3][2] = 2;
        A[4][0] = 3;
        A[4][1] = 3;
        A[4][2] = 4;
        A[5][0] = 1;
        A[5][1] = 4;
        A[5][2] = 4;
        A[6][0] = 4;
        A[6][1] = 1;
        A[6][2] = 1;

        System.out.println("Result: " + new Question2().solution(A));

    }

}
