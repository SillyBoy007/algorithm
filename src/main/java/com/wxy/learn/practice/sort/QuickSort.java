package com.wxy.learn.practice.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author wxy
 * @since 2020-06-15
 */
public class QuickSort {

    public static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        int m = partition(a, left, right);

        quickSort(a, left, m - 1);

        quickSort(a, m + 1, right);

    }

    public static int partition(int[] a, int left, int right) {
        int pivot = a[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    swap(a, i, j);
                    i++;
                }
            }
        }


        swap(a, i, right);

        return i;

    }

    public static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }


    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 6, 4, 5, -2, 4};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


}
