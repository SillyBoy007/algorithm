package com.wxy.learn.practice.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author wxy
 * @since 2020-06-03
 */
public class BubbleSort {
    public static void bubbleSort(int[] a) {
        int n = a.length;
        if (n <= 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            for (; j < n; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }

        }
    }

    public static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 1, 5, 7, 2};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
