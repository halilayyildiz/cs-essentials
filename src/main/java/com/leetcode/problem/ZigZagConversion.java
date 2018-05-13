package com.leetcode.problem;

public class ZigZagConversion
{

	public String convert(String s, int numRows)
	{
		if(s.isEmpty())
		{
			return "";
		}
		
		if(numRows == 1)
		{
			return s;
		}
		
		char[][] table = new char[numRows][s.length()];
		for (int i = 0; i < numRows; i++)
		{
			table[i] = new char[s.length()];
		}
		
		int row=0, col=0;
		boolean increaseColumn = false;
		for (int i = 0; i < s.length(); i++)
		{
			table[row][col] = s.charAt(i);
			if(row == numRows-1)
			{
				increaseColumn = true;
				row--;
				col++;
			}
			else
			{
				if(increaseColumn)
				{
					if(row == 0)
					{
						increaseColumn=false;
						row++;
					}
					else
					{
						row--;
					}
					col++;
				}
				else
				{
					row++;
				}
			}
		}
		
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < table.length; i++)
		{
			for (int j = 0; j < table[i].length; j++)
			{
				char temp = table[i][j];
				if(temp != '\u0000')
				{
					result.append(table[i][j]);
				}
				
				System.out.print(table[i][j] + " ");
				
				if(result.length() == s.length())
				{
					break;
				}
				
				
			}
			System.out.println();
		}

		return result.toString();
	}

	public static void main(String[] args)
	{
		new ZigZagConversion().convert("A", 2);
	}

}
