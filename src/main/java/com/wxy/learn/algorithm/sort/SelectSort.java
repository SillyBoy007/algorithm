package com.wxy.learn.algorithm.sort;

import java.util.Arrays;

/**
 * @author wxy
 */
public class SelectSort {
    public static void selectSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n-1; i++) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
       }
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,3,2,1};
        selectSort(arr,6);
        System.out.println(Arrays.toString(arr));
    }
}
