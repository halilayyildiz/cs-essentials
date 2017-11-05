package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class MaximalSquare
{
    private class Pair
    {
        int i, j;

        public Pair(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }

    public int maximalSquare(char[][] matrix)
    {
        if (matrix.length <= 0)
        {
            return 0;
        }

        List<Pair> entryList = new ArrayList<>();

        int SqSize = 0;
        int[][] matrixVal = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
        {
            matrixVal[i] = new int[matrix[0].length];
            for (int j = 0; j < matrix[0].length; j++)
            {
                matrixVal[i][j] = matrix[i][j] == '1' ? 1 : 0;
                entryList.add(new Pair(i, j));
                if (matrix[i][j] == '1')
                {
                    SqSize = 1;
                }
            }
        }

        if (SqSize != 1)
        {
            return 0;
        }

        while (!entryList.isEmpty())
        {
            SqSize++;

            List<Pair> newEntryList = new ArrayList<>();
            for (Pair entry : entryList)
            {
                int i = entry.i;
                int j = entry.j;
                if (matrix.length - i >= SqSize && matrix[0].length - j >= SqSize)
                {
                    int sum = sum(matrix, i, j, SqSize);
                    if (sum == SqSize * SqSize)
                    {
                        newEntryList.add(entry);
                    }
                }
            }
            if (newEntryList.isEmpty())
            {
                SqSize--;
                break;
            }
            entryList = newEntryList;
        }

        return SqSize * SqSize;
    }

    private int sum(char[][] matrix, int x, int y, int size)
    {
        int sum = 0;

        for (int i = x; i < x + size; i++)
        {
            for (int j = y; j < y + size; j++)
            {
                // System.out.println("x=" + x + " " + "y=" + y + " " + "i=" + i
                // + " " + "j=" + j + " " + "size=" + size);
                sum += (matrix[i][j] == '1') ? 1 : 0;
            }
        }
        return sum;
    }

    public static void main(String[] args)
    {
        // char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1',
        // '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' }
        // };
        char[][] matrix = { { '0', '1' } };
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }
}
