package com.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        Queue<String> queue = new LinkedList<>();
        Set<String> dictWords = new HashSet<>(wordList);

        queue.add(beginWord);
        int hopCount = 1;

        while (!queue.isEmpty())
        {
            Queue<String> NewQueue = new LinkedList<>();
            while (!queue.isEmpty())
            {
                String word = queue.poll();
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++)
                {
                    for (char c = 'a'; c <= 'z'; c++)
                    {
                        char temp = arr[i];
                        if (arr[i] != c)
                        {
                            arr[i] = c;
                        }

                        String newWord = new String(arr);

                        if (dictWords.contains(newWord))
                        {
                            if (newWord.equals(endWord))
                            {
                                return hopCount + 1;
                            }

                            NewQueue.add(newWord);
                            dictWords.remove(newWord);
                        }

                        arr[i] = temp;
                    }
                }
            }
            queue = NewQueue;
            hopCount++;
        }
        return 0;
    }

    public static void main(String[] args)
    {
        String[] wordList = { "hot", "dot", "dog", "lot", "log" };
        int ladderLength = new WordLadder().ladderLength("hit", "cog", new ArrayList<>(Arrays.asList(wordList)));
        System.out.println(ladderLength);

    }
}
