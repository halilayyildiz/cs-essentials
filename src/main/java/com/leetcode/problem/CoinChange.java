package com.leetcode.problem;

public class CoinChange
{
    public int coinChange(int[] coins, int amount)
    {
        if (amount == 0)
        {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++)
        {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i <= amount; i++)
        {
            for (int coin : coins)
            {
                long target = i + Long.valueOf(coin);
                if (target <= amount)
                {
                    if (dp[i] != Integer.MAX_VALUE)
                    {
                        dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
                    }
                }
            }
        }

        if (dp[amount] >= Integer.MAX_VALUE)
        {
            return -1;
        }

        return dp[amount];
    }

    public static void main(String[] args)
    {
        int[] coins = { 186, 419, 83, 408 };
        System.out.println(new CoinChange().coinChange(coins, 6249));
    }
}
