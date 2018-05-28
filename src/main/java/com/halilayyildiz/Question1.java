package com.halilayyildiz;

import java.util.HashMap;
import java.util.Map;

public class Question1
{
    public String solve()
    {
        Map<String, Integer> map = new HashMap<>();

        if (map.putIfAbsent("testKey", 0) != null)
        {
            map.put("testKey", map.get("testKey") + 1);
        }

        return "";
    }

    public static void main(String[] args)
    {

        String result = new Question1().solve();
        System.out.println("Result: " + result);
    }

}
