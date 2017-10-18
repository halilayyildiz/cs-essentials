package com.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String str : strs)
        {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (!anagramsMap.containsKey(sorted))
            {
                anagramsMap.put(sorted, new ArrayList<String>());
            }
            anagramsMap.get(sorted).add(str);
        }

        return new ArrayList<>(anagramsMap.values());
    }

}
