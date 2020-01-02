package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] a, int low, int high) {
        if (low >= high || a.length <= 1) {
            return;
        }


        int partition = partition(a, low, high);
        quickSort(a, low, partition - 1);
        quickSort(a, partition + 1, high);

    }

    public static int partition(int[] a, int low, int high) {
        int provit = a[low];
        int i = low;
        for (int j = low+1; j <= high; j++) {
            if (a[j] < provit && (i++ != j)){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        int tmp= a[low];
        a[low] = a[i];
        a[i] = tmp;
        return i;

    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 6, 4, 5, -2, 4};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
