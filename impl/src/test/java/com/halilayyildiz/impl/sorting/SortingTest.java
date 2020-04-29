package com.halilayyildiz.impl.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortingTest {

    @Test
    public void runMergeSort() {

        int[] actual = {5, 1, 6, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6};

        new MergeSort().sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void runQuickSort() {

        int[] actual = {5, 1, 6, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6};

        new QuickSort().sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void runHeapSort() {

        int[] actual = {5, 1, 6, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6};

        new HeapSort().sort(actual);
        assertArrayEquals(expected, actual);
    }
}
