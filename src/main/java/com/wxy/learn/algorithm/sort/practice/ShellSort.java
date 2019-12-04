package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }

        int step = n / 2;

        while (step >= 1) {
            for (int i = step; i < n; i++) {
                int value = arr[i];
                int j = i - step;
                for (; j >= 0; j = j - step) {
                    if (value < arr[j]) {
                        arr[j + step] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + step] = value;
            }
            step = step / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
