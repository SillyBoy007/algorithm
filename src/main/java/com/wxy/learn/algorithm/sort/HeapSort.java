package com.wxy.learn.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {


    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        //1.建堆复杂度
        buildHeap(arr);

        //2.排序
        int k = arr.length - 1;

        while (k > 0) {
            // 将堆顶元素（最大）与最后一个元素交换位置
            swap(arr, 0, k);

            // 将剩下元素重新堆化，堆顶元素变成最大元素
            heapify(arr, --k, 0);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tem = arr[j];
         arr[j] = arr[i];
         arr[i] = tem;
    }

    /**
     * 建堆
     *
     * @param arr
     */
    public static void buildHeap(int[] arr) {
        // (arr.length - 1) / 2 为最后一个叶子节点的父节点
        // 也就是最后一个非叶子节点，依次堆化直到根节点

        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, arr.length - 1, i);
        }

    }

    /**
     * 堆化
     *
     * @param arr
     * @param n
     * @param i
     */
    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            // 最大值位置
            int maxPos = i;
            // 与左子节点（i * 2 + 1）比较，获取最大值位置
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }

            // 最大值与右子节点（i * 2 + 2）比较，获取最大值位置
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }

            // 最大值是当前位置结束循环
            if (maxPos == i) {
                break;
            }

            // 与子节点交换位置
            swap(arr, i, maxPos);
            // 以交换后子节点位置接着往下查找
            i = maxPos;
        }
    }

    public static void main(String[] args) {
        int[] a = {9,5,1,1,2,3,7,5};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}