package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

public class ShellSort {
    public static void shellSort(int[] a) {
        int step = a.length / 2;

        while (step >= 1) {
            for (int i = step; i < a.length; i++) {
                int value = a[i];
                int j = i - step;
                for (; j >= 0; j = j - step) {
                    if (a[i] < a[j]) {
                        a[j + step] = a[j];
                    } else {
                        break;
                    }
                }
                a[j + step] = value;
                step = step / 2;
            }
        }


    }

    public static void main(String[] args) {
        int[] array = new int[]{6, 8, 4, 3, 2, 1, 9, 8, 7};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
