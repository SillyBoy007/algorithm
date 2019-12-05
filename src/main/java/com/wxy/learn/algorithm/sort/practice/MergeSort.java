package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr, int r) {
        division(arr, 0, r - 1);
    }

    private static void division(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = p + (r - p) / 2;

        division(arr, p, q);

        division(arr, q + 1, r);

        merge(arr, p, q, r);
    }

    private static void merge(int[] arr, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
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

        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[k++] = arr[start++];
        }

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
