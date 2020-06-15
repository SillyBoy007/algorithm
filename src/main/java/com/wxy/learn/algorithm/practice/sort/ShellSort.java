package com.wxy.learn.algorithm.practice.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author wxy
 * @since 2020-06-15
 */
public class ShellSort {

    public static void shellSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        int step = n / 2;

        while (step >= 1) {

            for (int i = step; i < n; i++) {
                int j = i - step;
                int tmp = a[i];
                for (; j >= 0; j = j - step) {
                    if (a[j] > tmp) {
                        a[j + step] = a[j];
                    } else {
                        break;
                    }
                }
                a[j + step] = tmp;
            }
            step = step / 2;
        }
    }


    public static void main(String[] args) {
        int[] a = {3, 4, 1, 5, 7, 2};
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }
}
