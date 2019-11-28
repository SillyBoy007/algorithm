package com.wxy.learn.algorithm.sort;

import java.util.Arrays;

/**
 * @author wxy
 */
public class InsertSort {
    public static void insertSort(int[] arr, int size) {
        if (size <= 1) {
            return;
        }
        int count = 0;

        for (int i = 1; i < size; i++) {
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
            System.out.println("第"+ ++count+"次循环:"+ Arrays.toString(arr));

        }
    }

    public static void main(String[] args) {
        int [] arr = {4,5,6,3,2,1};
        insertSort(arr,6);
        System.out.println(Arrays.toString(arr));
    }
}
