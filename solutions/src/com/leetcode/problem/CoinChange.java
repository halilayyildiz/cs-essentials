package com.leetcode.problem;

import java.util.Arrays;
import java.util.Stack;

public class CoinChange
{
    public int coinChange(int[] coins, int amount)
    {
        if (amount <= 0)
        {
            return -1;
        }

        Stack<Integer> usedCoins = new Stack<>();
        Arrays.sort(coins);
        

        int total = 0;
        int removeCount = 1;
        int selectedCoinIndex = coins.length - 1;
        while (total < amount)
        {
            usedCoins.push(coins[selectedCoinIndex]);
            total += coins[selectedCoinIndex];

            if (total == amount)
            {
                return usedCoins.size();
            }
            if (total > amount)
            {
                if (selectedCoinIndex > 0)
                {
                    selectedCoinIndex--;
                }
                else
                {
                    removeCount++;
                    selectedCoinIndex = coins.length - 1;
                }
                
                for (int i = removeCount; i > 0; i--)
                {
                    Integer poppedCoin = usedCoins.pop();
                    total -= poppedCoin;
                }
            }
            else
            {
                total -= coins[selectedCoinIndex];
            }

        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[] coins = { 1, 2, 5 };
        System.out.println(new CoinChange().coinChange(coins, 11));
    }
}
