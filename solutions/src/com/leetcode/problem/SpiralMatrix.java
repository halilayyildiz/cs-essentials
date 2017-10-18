package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix
{
    public List<Integer> spiralOrder(int[][] matrix)
    {
        ArrayList<Integer> result = new ArrayList<>();

        if (matrix.length == 0)
        {
            return result;
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int direction = 1; // RIGHT 1, DOWN 2, LEFT 3, UP 4;

        for (int i = 0, j = 0; true; )
        {
            if (i < 0 || j < 0 || i > matrix.length || j >= matrix[0].length
                    || visited[i][j])
            {
                return result;
            }
            result.add(matrix[i][j]);
            visited[i][j]=true;

            switch (direction)
            {
            case 1:
                if (j + 1 < matrix[0].length && !visited[i][j+1])
                {
                    j++;
                }
                else
                {
                    i++;
                    direction = 2;
                }
                break;
            case 2:
                if (i + 1 < matrix.length && !visited[i+1][j])
                {
                    i++;
                }
                else
                {
                    j--;
                    direction = 3;
                }
                break;
            case 3:
                if (j - 1 >= 0 && !visited[i][j-1])
                {
                    j--;
                }
                else
                {
                    i--;
                    direction = 4;
                }
                break;
            case 4:
                if (i - 1 >= 0 && !visited[i-1][j])
                {
                    i--;
                }
                else
                {
                    j++;
                    direction = 1;
                }
                break;
            }
        }
    }
}
