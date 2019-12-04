package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

/**
 * 第一次练习:
 * 完成度：100
 */
public class SelectSort {
    public static void selectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i+1; j < len; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;

        }
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,3,2,1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
