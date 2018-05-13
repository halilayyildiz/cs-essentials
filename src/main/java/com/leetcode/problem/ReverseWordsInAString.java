package com.leetcode.problem;

public class ReverseWordsInAString
{
    public String reverseWords(String s)
    {
        if (s.length() == 0)
        {
            return s;
        }

        String result = "";
        char[] input = s.toCharArray();

        int start = 0;
        for (int i = 0; i < input.length; i++)
        {
            if (input[i] == ' ' || i == input.length - 1)
            {
                // start and end indices are inclusive
                int end = (i == input.length - 1) ? i : i - 1;
                for (int j = 0; start+j < end - j; j++)
                {
                    char temp = input[start+j];
                    input[start+j] = input[end - j];
                    input[end - j] = temp;
                }
                start = end + 1;
            }
        }
        
        return String.valueOf(input);
    }

    public static void main(String[] args)
    {
        ReverseWordsInAString obj = new ReverseWordsInAString();
        
        System.out.println(obj.reverseWords(" ")); 
        System.out.println(obj.reverseWords(" test me"));  
        System.out.println(obj.reverseWords("test me ")); 
        System.out.println(obj.reverseWords("  test me"));
        System.out.println(obj.reverseWords(" test me  "));
        System.out.println(obj.reverseWords("  test   me    "));
        System.out.println(obj.reverseWords("t"));
        System.out.println(obj.reverseWords("      "));
        System.out.println(obj.reverseWords("        t       "));
    }
}
