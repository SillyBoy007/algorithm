package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
