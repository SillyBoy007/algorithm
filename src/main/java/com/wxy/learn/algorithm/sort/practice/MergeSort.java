package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] a, int n) {
        reMerge(a, 0, n - 1);
    }

    public static void reMerge(int[] a, int low, int r) {
        if (low >= r) {
            return;
        }

        int m = low + (r - low) / 2;

        reMerge(a, low, m);
        reMerge(a, m + 1, r);
        merge(a, low, m, r);
    }

    public static void merge(int[] a, int low, int m, int r) {
        int i = low;
        int j = m + 1;
        int k = 0;
        int[] tmp = new int[r - low + 1];

        while (i <= m && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        while (i<=m){
            tmp[k++] = a[i++];
        }

        while (j<=r){
            tmp[k++] = a[j++];
        }
        for (int l=0;l<tmp.length;l++){
            a[l+low] = tmp[l];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 6, 4, 5,-2,-1};
        mergeSort(array,  array.length);
        System.out.println(Arrays.toString(array));
    }
}
