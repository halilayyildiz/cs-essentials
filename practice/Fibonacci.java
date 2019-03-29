package com.halilayyildiz.practice;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(recursion(3));
    }

    public static int recursion(int n) {
        if (n == 0 || n == 1)
            return 1;

        return recursion(n - 1) + recursion(n - 2);
    }

    public static int iterative(int n) {

        return 0;
    }

    public static int memoization(int n) {

        return 0;
    }
}