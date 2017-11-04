package com.leetcode.problem;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ImplementTrie
{
    private class TEdge
    {
        char val;
        boolean endEdge = false;
        Set<TEdge> edges = new HashSet<>();
    }

    private Set<TEdge> rootEdges = new HashSet<>();

    /** Inserts a word into the trie. */
    public void insert(String word)
    {
        Set<TEdge> targetEdges = rootEdges;

        for (int i = 0; i < word.length(); i++)
        {
            char letter = word.charAt(i);
            TEdge edgeFound = null;
            for (TEdge edge : targetEdges)
            {
                if (edge.val == letter)
                {
                    edgeFound = edge;
                    continue;
                }
            }

            if (edgeFound != null)
            {
                targetEdges = edgeFound.edges;
                if (i == word.length() - 1)
                {
                    edgeFound.endEdge = true;
                }
            }
            else
            {
                TEdge newEdge = new TEdge();
                newEdge.val = word.charAt(i);
                newEdge.endEdge = (i == word.length() - 1) ? true : false;
                targetEdges.add(newEdge);
                targetEdges = newEdge.edges;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word)
    {
        Set<TEdge> targetEdges = rootEdges;

        for (int i = 0; i < word.length(); i++)
        {
            char letter = word.charAt(i);
            TEdge edgeFound = null;
            for (TEdge edge : targetEdges)
            {
                if (edge.val == letter)
                {
                    edgeFound = edge;
                    continue;
                }
            }

            if (edgeFound != null)
            {
                targetEdges = edgeFound.edges;

                if (i == word.length() - 1)
                {
                    if (edgeFound.endEdge)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given
     * prefix.
     */
    public boolean startsWith(String prefix)
    {
        Set<TEdge> targetEdges = rootEdges;

        for (int i = 0; i < prefix.length(); i++)
        {
            char letter = prefix.charAt(i);
            TEdge edgeFound = null;
            for (TEdge edge : targetEdges)
            {
                if (edge.val == letter)
                {
                    edgeFound = edge;
                    continue;
                }
            }

            if (edgeFound != null)
            {
                targetEdges = edgeFound.edges;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        ImplementTrie obj = new ImplementTrie();

        obj.insert("halil");
        System.out.println("Test : " + obj.search(""));
        System.out.println("Test : " + obj.startsWith("ha"));
        System.out.println("Test : " + obj.search("ha"));
        System.out.println("Test : " + obj.startsWith("haa"));
        System.out.println("Test : " + obj.search("halil"));
        System.out.println("Test : " + obj.startsWith("halil"));
        System.out.println("Test : " + obj.search("halilasd"));
        System.out.println("Test : " + obj.search("hali"));
        obj.insert("hali");
        System.out.println("Test : " + obj.search("hali"));
    }
}
