package com.leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII
{
	private Map<String, List<String>> resultCache = new HashMap<>();

	public List<String> wordBreak(String s, List<String> wordDict)
	{
		List<String> results = new ArrayList<>();

		for (String word : wordDict)
		{
			if (s.startsWith(word))
			{
				String remStr = s.substring(word.length());
				if (word.length() == s.length())
				{
					results.add(word);
				}
				else
				{
					if (!resultCache.containsKey(remStr))
					{
						List<String> list = wordBreak(remStr, wordDict);
						resultCache.put(remStr, list);

					}

					List<String> list = resultCache.get(remStr);
					for (String string : list)
					{
						results.add(word + " " + string);
					}
				}
			}
		}

		return results;
	}

	public static void main(String[] args)
	{
		List<String> wordDict = new ArrayList<>();
		wordDict.add("a");
		wordDict.add("b");
		wordDict.add("bbb");
		wordDict.add("bbbb");

		List<String> wordBreak = new WordBreakII().wordBreak("bb", wordDict);
		wordBreak.stream().forEach(word -> System.out.println(word));

		List<String> dict2 = new ArrayList<>();
		dict2.add("cat");
		dict2.add("cats");
		dict2.add("and");
		dict2.add("sand");
		dict2.add("dog");

		List<String> wordBreak2 = new WordBreakII().wordBreak("catsanddog", dict2);
		wordBreak2.stream().forEach(word -> System.out.println(word));

	}
}
