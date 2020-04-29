package com.halilayyildiz.impl.sorting;

public class QuickSort {

    public void sort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int lo, int hi) {
        if (lo < hi) {
            int p = partition(A, lo, hi);
            quickSort(A, lo, p - 1);
            quickSort(A, p + 1, hi);
        }
    }

    private int partition(int[] A, int lo, int hi) {
        int pivot = A[hi];

        for (int i = lo; i <= hi; i++) {
            if (A[i] < pivot) {
                swap(A, lo, i);
                lo++;
            }
        }

        swap(A, lo, hi);
        return lo;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}