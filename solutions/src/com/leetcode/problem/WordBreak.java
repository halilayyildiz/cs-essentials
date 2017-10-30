package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class WordBreak
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        boolean visited[] = new boolean[s.length() + 1];

        visited[0] = true;
        for (int i = 0; i < s.length(); i++)
        {
            if (!visited[i])
            {
                continue;
            }

            for (String word : wordDict)
            {
                int end = i + word.length();
                if (end > s.length())
                {
                    continue;
                }

                if (visited[end])
                {
                    continue;
                }

                if (s.substring(i, end).equals(word))
                {
                    visited[end] = true;
                }
            }
        }

        return visited[s.length()];
    }

    public static void main(String[] args)
    {
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");

        boolean result = new WordBreak().wordBreak(s, wordDict);
        System.out.println("Result: " + result);

    }

}
