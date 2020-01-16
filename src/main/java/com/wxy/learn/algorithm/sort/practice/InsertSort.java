package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

/**
 * has not impl
 */
public class InsertSort {

    public static void insertSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int value = a[i];
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }

            a[j + 1] = value;
        }
    }


    public static void main(String[] args) {
        int[] a = {7, 3, 1, 2, 4};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
