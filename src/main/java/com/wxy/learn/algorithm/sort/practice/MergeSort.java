package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

public class MergeSort {


    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    private static void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = p + (r - p) / 2;

        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        merge(a, p, q, r);

    }

    private static void merge(int[] arr, int p, int q, int r) {
        int left = p;
        int right = q + 1;

        int n = r - p + 1;

        int[] tmp = new int[n];
        int k = 0;

        while (left <= q && right <= r) {
            if (arr[left] < arr[right]) {
                tmp[k++] = arr[left++];
            } else {
                tmp[k++] = arr[right++];
            }
        }

        while (left <= q) {
            tmp[k++] = arr[left++];
        }

        while (right<=r){
            tmp[k++] = arr[right++];
        }

        for (int i=0;i<tmp.length;i++){
            arr[p+i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{6, 5, 4, 3, 2, 1};
        mergeSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
