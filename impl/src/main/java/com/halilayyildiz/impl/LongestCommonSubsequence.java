package com.halilayyildiz.impl;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";

        int m = X.length();
        int n = Y.length();

        System.out.println("Length of Longest Common Substring is "
                + lcs(X.toCharArray(), Y.toCharArray(), m, n));
    }

    static int lcs(char X[], char Y[], int m, int n) {


        return -1;
    }


}