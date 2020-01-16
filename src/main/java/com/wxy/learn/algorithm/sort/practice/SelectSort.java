package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

public class SelectSort {
    public static void selectSort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            BaseSort.swap(a, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 4, 1, 2, 3};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
