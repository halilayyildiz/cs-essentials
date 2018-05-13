package com.leetcode.problem;

public class BestTimeToBuyAndSellStockIII
{
    public int maxProfit(int[] prices)
    {
        int maxProfit = 0;

        if (prices.length == 0)
        {
            return 0;
        }

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        for (int i = 0, min = prices[0], profit = 0; i < prices.length; i++)
        {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
            left[i] = profit;
        }

        for (int i = prices.length - 1, max = prices[prices.length - 1], profit = 0; i >= 0; i--)
        {
            max = Math.max(max, prices[i]);
            profit = Math.max(profit, max - prices[i]);
            right[i] = profit;
        }

        for (int i = 0; i < prices.length; i++)
        {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args)
    {
        int[] prices = { 7, 1, 5, 3, 6, 4, 5, 9 };
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(prices));
    }

}
