package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

public class ShellSort {
    public static void shellSort(int[] a) {
        int len = a.length;
        if (len <= 1) {
            return;
        }

        int step = len / 2;

        while (step >= 1) {
            for (int i = step; i < len; i++) {
                int j = i - step;
                int value = a[i];

                for (; j >= 0; j = j - step) {
                    if (value < a[j]){
                        a[j+step] = a[j];
                    }
                }
                a[j+step] = value;

            }
            step = step / 2;
        }
    }

    public static void main(String[] args) {
        int [] a = {6,3,1};
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }
}
