package com.leetcode.problem;

public class BestTimeToBuyAndSellStockWithCooldown
{
    public int maxProfit(int[] prices)
    {
        if (prices.length < 2)
        {
            return 0;
        }

        int profit = 0;
        int buyPrice = prices[0];
        
        for (int i = 1; i < prices.length; i++)
        {
            if (i < prices.length - 2)
            {
                if (prices[i - 1] < prices[i])
                {
                    if(prices[i + 2] <= prices[i])
                    {
                        profit += prices[i] - prices[i - 1];
                    }
                    else
                    {
                        buyPrice = prices[i - 1];
                    }
                }
                else
                {
                    buyPrice = prices[i - 1];
                }
            }
            else
            {
                if (prices[i - 1] < prices[i])
                {
                    profit += prices[i] - prices[i - 1];
                }
            }
        }

        return profit;
    }

    public static void main(String[] args)
    {
        int[] prices = { 6, 1, 3, 2, 4, 7 };
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(prices));
    }

}
