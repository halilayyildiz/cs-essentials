package com.leetcode.problem;

public class UniquePaths
{
    public int uniquePaths(int m, int n)
    {
        if (m == 0 || n == 0)
        {
            return 0;
        }

        int[][] table = new int[m][n];

        for (int i = 0; i < n; i++)
        {
            table[0][i] = 1;
        }

        for (int i = 0; i < m; i++)
        {
            table[i][0] = 1;
        }

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }

        return table[m - 1][n - 1];
    }

    public static void main(String[] args)
    {
        System.out.println(new UniquePaths().uniquePaths(2, 1));

        System.out.println("------- 2 2 -> 2");
        System.out.println(new UniquePaths().uniquePaths(2, 2));
        System.out.println(new UniquePaths().uniquePaths(3, 2));
        System.out.println(new UniquePaths().uniquePaths(4, 2));
        System.out.println(new UniquePaths().uniquePaths(5, 2));

        System.out.println("------- 3 3 -> 6");
        System.out.println(new UniquePaths().uniquePaths(1, 3));
        System.out.println(new UniquePaths().uniquePaths(2, 3));
        System.out.println(new UniquePaths().uniquePaths(3, 3));
        System.out.println(new UniquePaths().uniquePaths(4, 3));
        System.out.println(new UniquePaths().uniquePaths(5, 3));
        System.out.println(new UniquePaths().uniquePaths(6, 3));
        System.out.println(new UniquePaths().uniquePaths(7, 3));
        System.out.println(new UniquePaths().uniquePaths(8, 3));

        System.out.println("------- 4 4 - > 24");
        System.out.println(new UniquePaths().uniquePaths(1, 4));
        System.out.println(new UniquePaths().uniquePaths(2, 4));
        System.out.println(new UniquePaths().uniquePaths(3, 4));
        System.out.println(new UniquePaths().uniquePaths(4, 4));
        System.out.println(new UniquePaths().uniquePaths(5, 4));
        System.out.println(new UniquePaths().uniquePaths(6, 4));
        System.out.println(new UniquePaths().uniquePaths(7, 4));

        System.out.println("------- 5 5 - > 120");
        System.out.println(new UniquePaths().uniquePaths(5, 5));
        System.out.println(new UniquePaths().uniquePaths(6, 5));
        System.out.println(new UniquePaths().uniquePaths(7, 5));
        System.out.println(new UniquePaths().uniquePaths(8, 5));

        System.out.println("------- 6 6  - > 720");
        System.out.println(new UniquePaths().uniquePaths(6, 6));
        System.out.println(new UniquePaths().uniquePaths(7, 6));
        System.out.println(new UniquePaths().uniquePaths(8, 7));
        System.out.println(new UniquePaths().uniquePaths(9, 6));
        System.out.println("-------");

        System.out.println(new UniquePaths().uniquePaths(3, 5));
        System.out.println(new UniquePaths().uniquePaths(5, 3));
        System.out.println(new UniquePaths().uniquePaths(11, 5));
        System.out.println(new UniquePaths().uniquePaths(5, 11));
        // System.out.println(new UniquePaths().uniquePaths(99, 99));
    }
}
