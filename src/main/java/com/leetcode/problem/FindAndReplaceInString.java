package com.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString
{

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets)
    {
        if (indexes.length < 1)
        {
            return S;
        }

        Map<Integer, String> sourceMap = new HashMap<>();
        Map<Integer, String> targetMap = new HashMap<>();
        for (int i = 0; i < indexes.length; i++)
        {
            sourceMap.put(indexes[i], sources[i]);
            targetMap.put(indexes[i], targets[i]);
        }

        String result = "";
        for (int i = 0; i < S.length(); i++)
        {
            String sourceStr = sourceMap.get(i); 
            if (sourceStr != null && S.substring(i, i + sourceStr.length()).equals(sourceStr))
            {
                result += targetMap.get(i);
                i += sourceStr.length() - 1;
            }
            else
            {
                result += S.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] indexes = { 0, 2 };
        String[] sources = { "a", "cd" };
        String[] targets = { "eee", "ffff" };
        String result = new FindAndReplaceInString().findReplaceString("abcd", indexes, sources, targets);
        System.out.println(result);
    }
}
