package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {

        int len = arr.length;
        if (len <= 1) {
            return;
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            boolean flag = false;

            for (int j = 0; j < len - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                }
            }

            if (!flag) {
                break;  // 没有数据交换，提前退出
            }

            System.out.println("第" + ++count + "次循环:" + Arrays.toString(arr));

        }

    }


    public static void bubbleSort2(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return;
        }

        int lastChange = 0;
        int sortBorder = len - 1;
        int count = 0;

        for (int i = 0; i < len; i++) {
            boolean isChange = false;
            for (int j = 0; j < sortBorder; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    isChange = true;
                    lastChange = j;
                }

                System.out.println("第" + ++count + "次循环:" + Arrays.toString(arr));

            }
            sortBorder = lastChange;

            if (!isChange) {
                break;
            }
        }
    }

    public static void underBubbleSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return;
        }

        boolean isChange = false;
        for (int i = 0; i < len-1; i++) {
            for (int j = len - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    isChange = true;
                }
            }

            if (!isChange){
                break;
            }

        }
    }


    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        underBubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
