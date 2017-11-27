package com.leetcode.problem;

public class RotateImage
{
	
	// O(1) space solution
	public void rotate(int[][] matrix)
	{
		int n = matrix.length;

		for (int s = 0, e = n - 1; s < e; s++, e--)
		{
			for (int i = 0; s+i < e; i++)
			{
				int temp = matrix[s + i][e];
				matrix[s + i][e] = matrix[s][s + i];

				int temp2 = matrix[e][e - i];
				matrix[e][e - i] = temp;

				int temp3 = matrix[e - i][s];
				matrix[e - i][s] = temp2;

				matrix[s][s + i] = temp3;
			}
		}
	}

	public static void main(String[] args)
	{
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(" ");
		}

		new RotateImage().rotate(matrix);

		System.out.println(" ");
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(" ");
		}

	}
}
