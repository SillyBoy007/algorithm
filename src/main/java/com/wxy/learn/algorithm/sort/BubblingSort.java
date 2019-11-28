package com.wxy.learn.algorithm.sort;

import java.util.Arrays;

/**
 * @author wxy
 * 冒泡排序，冒泡排序优化
 */
public class BubblingSort {
    public static void bubblingSort(int[] arr, int size) {
        if (size <= 1) {
            return;
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = 0; j < size - 1; j++) {
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
            System.out.println("第"+ ++count+"次循环:"+Arrays.toString(arr));
        }
    }

    /**
     * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     */

    public static void bubbleSort2(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        // 最后一次交换的位置
        int lastExchange = 0;
        int count = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;
        for (int i = 0; i < n; i++) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                    // 更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag) {
                break;    // 没有数据交换，提前退出
            }
            System.out.println("第"+ ++count+"次循环:"+Arrays.toString(a));

        }

    }


    public static void main(String[] args) {
        int [] a = {4,5,6,3,2,1};
        bubbleSort2(a,6);
        System.out.println(Arrays.toString(a));
    }
}
