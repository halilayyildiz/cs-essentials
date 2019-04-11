package com.halilayyildiz.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(recursion(3));
    }

    // No optimization
    // Complexity: O(2^N)
    public static long recursion(long n) {
        if (n == 0 || n == 1)
            return 1;

        return recursion(n - 1) + recursion(n - 2);
    }

    // Memoization solution (top-down)
    // Complexity: O(N) — time, O(N) — space
    private static Map<Long, Long> memo = new ConcurrentHashMap<>();

    public static long memoization(long n) {
        if (n == 0 || n == 1)
            return 1;

        if (!memo.containsKey(n - 1))
            memo.put(n - 1, memoization(n - 1));
        if (!memo.containsKey(n - 2))
            memo.put(n - 2, memoization(n - 2));

        return memo.get(n - 1) + memo.get(n - 2);
    }

    // Dynamic programming solution (bottom-up)
    // Complexity: O(N) — time, O(1) — space
    public static long iterative(long n) {
        if (n == 0 || n == 1)
            return 1;

        long f1 = 1;
        long f2 = 1;

        for (int i = 2; i <= n; i++) {
            long fib = f1 + f2;
            f1 = f2;
            f2 = fib;
        }

        return f2;
    }
}