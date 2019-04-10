package com.halilayyildiz.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void test() {
        BinarySearch instance = new BinarySearch();

        assertEquals(instance.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 1), 1);
        assertEquals(instance.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 4), 4);
        assertEquals(instance.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 10), 10);
        assertEquals(instance.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 12), 12);
        assertEquals(instance.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, -5), -1);
        assertEquals(instance.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 16), -1);
        assertEquals(instance.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 0), 0);
    }

}
