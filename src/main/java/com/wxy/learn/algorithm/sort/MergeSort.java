package com.wxy.learn.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    // 归并排序算法, a是数组，n表示数组大小

    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    private static void mergeSortInternally(int[] a, int p, int r) {
        System.out.println("r:"+r+","+"p:"+p);

        // 递归终止条件
        if (p >= r) {
            return;
        }

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;

        mergeSortInternally(a, p, q);

        mergeSortInternally(a, q + 1, r);

        merge(a, p, q, r);
    }

    private static void merge(int[] arr, int p, int q, int r) {

        int i = p;
        int j = q + 1;
        int k = 0;
        System.out.println("r:"+r+","+"i:"+i+",j:"+j);

        // 申请一个大小跟a[p...r]一样的临时数组
        int[] tmp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        int start = i;
        int end = q;

        // 判断哪个子数组中有剩余的数据
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = arr[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]

        for (i = 0; i <= r - p; ++i) {
            arr[p + i] = tmp[i];
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{6, 5, 4, 3, 2, 1};
        mergeSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

}