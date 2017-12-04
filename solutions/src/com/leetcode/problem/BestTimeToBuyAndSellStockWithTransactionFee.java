package com.leetcode.problem;

public class BestTimeToBuyAndSellStockWithTransactionFee
{
    public int maxProfit(int[] prices, int fee)
    {
        if (prices.length == 0)
        {
            return 0;
        }

        int profit = 0;
        int buyPrice = prices[0];

        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] > buyPrice + fee)
            {
                profit += prices[i] - (buyPrice + fee);
                buyPrice = prices[i] - fee;
            }
            else
            {
                if (prices[i] < buyPrice)
                {
                    buyPrice = prices[i];
                }
            }
        }

        return profit;
    }

    public static void main(String[] args)
    {
        int[] prices = { 1, 3, 7, 5, 10, 3 };
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(prices, 3));
    }
}
