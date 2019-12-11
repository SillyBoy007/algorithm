package com.wxy.learn.algorithm.sort.learn;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            // 切分
            int m = partition(a, low, high);
            // 将左半部分排序
            quickSort(a, low, m - 1);
            // 将右半部分排序
            quickSort(a, m + 1, high);
        }

    }

    public static int partition(int[] a, int low, int high) {
        // 将数组切分为 a[low..i-1], a[i], a[i+1..high]
        // 切分元素
        int p = a[low];
        // 下一个小于切分元素可插入的位置
        int i = low;
        // 从切分元素下一个位置开始，遍历整个数组，进行分区
        for (int j = low + 1; j <= high; j++) {
            // 往前移动比切分元素小的元素
            if (a[j] <= p && (i++ != j)) {
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
        // 交换中枢(切分)元素
        int tmp = a[low];
        a[low] = a[i];
        a[i] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 6, 4, 5,-2,4};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
