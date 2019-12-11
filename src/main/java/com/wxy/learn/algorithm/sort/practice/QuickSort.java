package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] a, int n) {
        reQuick(a, 0, n - 1);
    }

    public static void reQuick(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = quick(a, low, high);
        reQuick(a, low, pivot - 1);
        reQuick(a, pivot + 1, high);

    }

    public static int quick(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                if (j == i) {
                    i++;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[high];
        a[high] = a[i];
        a[i] = tmp;

        return i;
    }


    public static void main(String[] args) {
        int[] array = new int[]{6, 8, 4, 3, 2, 1,9,8,7};
        quickSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
