package com.leetcode.problem;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MinimumPathSum
{
	public int minPathSum(int[][] grid)
	{
		List<SimpleEntry<Integer, Integer>> nodesToVisit = new ArrayList<SimpleEntry<Integer, Integer>>();
		
		if(grid.length == 0)
		{
			return 0;
		}
		
		int[][] grid2 = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid2.length; i++) 
		{
			for (int j = 0; j < grid2[i].length; j++) 
			{
				grid2[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int m = grid.length;
		int n = grid[0].length;
		grid2[0][0] = grid[0][0];
		
		nodesToVisit.add(new SimpleEntry<Integer, Integer>(0, 0));
		while(!nodesToVisit.isEmpty())
		{
			List<SimpleEntry<Integer, Integer>> nodesToVisit2 = new ArrayList<SimpleEntry<Integer, Integer>>(nodesToVisit);
			nodesToVisit.clear();
			
			for (Iterator<SimpleEntry<Integer, Integer>> iterator = nodesToVisit2.iterator(); iterator.hasNext();) 
			{
				SimpleEntry<Integer, Integer> simpleEntry = iterator.next();
				
				int i = simpleEntry.getKey();
				int j = simpleEntry.getValue();
				
				if(i+1 < m)
				{
					int pathVal = grid2[i][j] + grid[i+1][j];
					if(grid2[i+1][j] > pathVal)
					{
						grid2[i+1][j] = pathVal;
						nodesToVisit.add(new SimpleEntry<Integer, Integer>(i+1, j));
					}
				}
				if(j+1 < n)
				{
					int pathVal = grid2[i][j] + grid[i][j+1];
					if(grid2[i][j+1] > pathVal)
					{
						grid2[i][j+1] = pathVal;
						nodesToVisit.add(new SimpleEntry<Integer, Integer>(i, j+1));
					}
				}
			}
			
		}
		
		return grid2[m-1][n-1];
	}

	public static void main(String[] args)
	{
		int[][] grid = { { 1, 2, 3, 4, 5 }, { 30, 4, 5, 2, 1 }, { 10, 23, 1, 1, 1 }, { 0, 0, 3, 4, 5 }, { 4, 12, 50, 20000, 1 } };
		new MinimumPathSum().minPathSum(grid);

	}

}
