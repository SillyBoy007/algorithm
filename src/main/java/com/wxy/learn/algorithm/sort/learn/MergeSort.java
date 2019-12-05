package com.wxy.learn.algorithm.sort.learn;

import java.util.Arrays;

public class MergeSort {
    /**
     * 递归实现
     * @param a
     * @param low
     * @param high
     */
    public static void mergeSort(int[] a, int low, int high) {
        // 要排序的数组 a[low..high]
        // 是否还能再二分 low >= high (0 或 1 个元素)
        if (low < high) {
            // 取中间值，避免 int 溢出
            int mid = low + (high - low) / 2;
            // 将左半边排序
            mergeSort(a, low, mid);
            // 将右半边排序
            mergeSort(a, mid + 1, high);

            // 归并左右两边
            merge(a, low, mid, high);
        }
    }
    /**
     * 非递归实现
     * @param a
     */
    public static void unRecursiveMergeSort(int[] a, int n) {
        int low = 0, high = 0, mid = 0;
        // 待归并数组长度，1 2 4 8 ...
        int len = 1; // 从最小分割单位 1 开始
        while(len <= n) {
            // 按分割单位遍历数组并合并
            for (int i = 0; i + len <= n; i += len * 2) {
                low = i;
                // mid 变量主要是在合并时找到右半边数组的起始下标
                mid = i + len - 1;
                high = i + 2 * len - 1;
                // 防止超过数组长度
                if (high > n - 1) {
                    high = n - 1;
                }
                // 归并两个有序的子数组
                merge(a, low, mid, high);
            }
            len *= 2; // 增加切分单位
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        // 合并后元素总数
        int n = high - low + 1;
        // 临时合并数组
        int[] b = new int[n];
        // 左边有序序列起始下标
        int left = low,
       // 右边有序序列起始下标
        right = mid + 1,
        bIdx = 0;
        // 按升序归并到新数组  b 中
        while (left <= mid && right <= high) {
            if (a[left] <= a[right]){
                b[bIdx++] = a[left++];
            }else {
                b[bIdx++] = a[right++];
            }
        }
        // 右边序列已拷贝完毕，左边还有剩余，将其依次拷贝到合并数组中
        while (left <= mid) {
            b[bIdx++] = a[left++];
        }
        // 左边序列已拷贝完毕，右边还有剩余，将其依次拷贝到合并数组中
        while (right <= high) {
            b[bIdx++] = a[right++];
        }
        // 将归并后的数组元素拷贝到原数组适当位置
        for (int k = 0; k < n; k++) {
            a[low + k] = b[k];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{6,5,4,3,2,1};
        mergeSort(array, 0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
