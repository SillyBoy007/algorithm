package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void shellSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        int step = n / 2;


    }

    public static void main(String[] args) {
        int[] a = {8, 2, 1, 3, 7, 4, 5, 6};
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }
}
