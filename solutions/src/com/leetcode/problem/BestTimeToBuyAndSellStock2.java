package com.leetcode.problem;

public class BestTimeToBuyAndSellStock2
{
    public int maxProfit(int[] prices)
    {
        if (prices.length == 0)
        {
            return 0;
        }

        int profit = 0;

        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] > prices[i - 1])
            {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args)
    {
        int[] prices = { 7, 1, 5, 3, 6, 4, 5, 9 };
        System.out.println(new BestTimeToBuyAndSellStock2().maxProfit(prices));
    }

}
