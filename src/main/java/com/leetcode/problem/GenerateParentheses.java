package com.leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParentheses
{
    public List<String> generateParenthesis(int n)
    {
        Map<String, Integer> items = new HashMap<>();
        if (n == 0)
        {
            return new ArrayList<>();
        }
        if (n == 1)
        {
            items.put("()", 1);
            return new ArrayList<>(items.keySet());
        }

        items.put("(", 1);
        for (int i = 1; i < n * 2; i++)
        {
            Map<String, Integer> newItems = new HashMap<>();
            for (Map.Entry<String, Integer> item : items.entrySet())
            {
                int openCount = item.getKey().length() - item.getKey().replace("(", "").length();

                if (openCount < n)
                {
                    newItems.put(item.getKey() + "(", item.getValue() + 1);
                }
                if (item.getValue() > 0 && item.getValue() < n)
                {
                    newItems.put(item.getKey() + ")", item.getValue() - 1);
                }
                if (item.getValue() >= 0 && openCount == n)
                {
                    newItems.put(item.getKey() + ")", item.getValue());
                }
            }
            items = newItems;
        }

        return new ArrayList<>(items.keySet());
    }

    public static void main(String[] args)
    {
        List<String> list = new GenerateParentheses().generateParenthesis(4);
        list.stream().forEach(item -> System.out.println(item));
    }
}
