package com.halilayyildiz.impl;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.Temporal;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void calcFibonacci() {
        Instant starts, ends;

        starts = Instant.now();
        print("Recursive");
        assertEquals(Fibonacci.recursion(45), 1836311903);
        ends = Instant.now();
        print(starts, ends);

        starts = Instant.now();
        print("Memoization");
        assertEquals(Fibonacci.memoization(45), 1836311903);
        ends = Instant.now();
        print(starts, ends);

        starts = Instant.now();
        print("Dynamic Programming");
        assertEquals(Fibonacci.iterative(45), 1836311903);
        ends = Instant.now();
        print(starts, ends);
    }

    private static void print(Temporal starts, Temporal ends) {
        String duration = Duration.between(starts, ends).toString()
                .substring(2)
                .replaceAll("(\\d[HMS])(?!$)", "$1 ")
                .toLowerCase();

        System.out.println(duration + "\n");
    }

    private static void print(String msg) {
        System.out.println(msg);
    }
}
