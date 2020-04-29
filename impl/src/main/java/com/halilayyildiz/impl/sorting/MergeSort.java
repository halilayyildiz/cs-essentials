package com.halilayyildiz.impl.sorting;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] A) {
        mergeSort(A);
    }

    private void mergeSort(int[] A) {
        int n = A.length;

        if (n < 2)
            return;

        int mid = n / 2;

        int[] left = Arrays.copyOfRange(A, 0, mid);
        int[] right = Arrays.copyOfRange(A, mid, n);

        mergeSort(left);
        mergeSort(right);

        merge(A, left, right);
    }

    private void merge(int[] A, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length)
            A[k++] = left[i] <= right[j] ? left[i++] : right[j++];

        while (i < left.length)
            A[k++] = left[i++];

        while (j < right.length)
            A[k++] = right[j++];
    }
}