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
        /**
         * 左边排序
         */
        mergeSortInternally(a, p, q);
        /**
         * 右边边排序
         */
        mergeSortInternally(a, q + 1, r);

        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int low = p;
        int high = q + 1;
        int[] tmp = new int[r - p + 1];
        int k = 0;
        while (low <= q && high <= r) {
            if (a[low] <= a[high]) {
                tmp[k++] = a[low ++];
            }else {
                tmp[k++] = a[high ++];
            }
        }

        while (low<=q){
            tmp[k++] = a[low ++];
        }
        while (high<=r){
            tmp[k++] = a[high ++];
        }

        for (int i=0;i<tmp.length;i++){
            a[p+i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int [] a = {6,5,4,3,2,1};
        mergeSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }
}
