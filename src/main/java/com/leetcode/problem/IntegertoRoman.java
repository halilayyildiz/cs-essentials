package com.leetcode.problem;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntegertoRoman
{
    public String intToRoman(int num)
    {
        if (num < 1)
        {
            return "";
        }

        StringBuilder result = new StringBuilder();

        Map<String, String> changeMap = new LinkedHashMap<String, String>();
        Map<Integer, String> romanMap = new LinkedHashMap<Integer, String>();

        changeMap.put("DCCCC", "CM"); // 900
        changeMap.put("CCCC", "CD"); // 400
        changeMap.put("LXXXX", "XC"); // 90
        changeMap.put("XXXX", "XL"); // 40
        changeMap.put("VIIII", "IX"); // 9
        changeMap.put("IIII", "IV"); // 4

        romanMap.put(1000, "M");
        romanMap.put(500, "D");
        romanMap.put(100, "C");
        romanMap.put(50, "L");
        romanMap.put(10, "X");
        romanMap.put(5, "V");
        romanMap.put(3, "III");
        romanMap.put(2, "II");
        romanMap.put(1, "I");

        Iterator<Map.Entry<Integer, String>> iter1 = romanMap.entrySet().iterator();
        while (iter1.hasNext())
        {
            Map.Entry<Integer, String> entry = iter1.next();
            int count = num / entry.getKey();
            if (count > 0)
            {
                num -= (count * entry.getKey());
                while (count > 0)
                {
                    result.append(entry.getValue());
                    count--;
                }
            }
        }

        Iterator<Map.Entry<String, String>> iter2 = changeMap.entrySet().iterator();
        while (iter2.hasNext())
        {
            Map.Entry<String, String> entry = iter2.next();
            int index = result.indexOf(entry.getKey());
            if (index >= 0)
            {
                result.replace(index, index + entry.getKey().length(), entry.getValue());
            }
        }

        return result.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(new IntegertoRoman().intToRoman(9));
        System.out.println(new IntegertoRoman().intToRoman(399));
        System.out.println(new IntegertoRoman().intToRoman(2543));
        System.out.println(new IntegertoRoman().intToRoman(3773));
    }
}
