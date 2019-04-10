package com.halilayyildiz.impl.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeSortTest {

    @Test
    public void test() {

        int[] actual = {5, 1, 6, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6};

        new MergeSort().mergeSort(actual);
        assertArrayEquals(expected, actual);
    }

}
