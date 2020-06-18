package com.wxy.learn.practice.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author wxy
 * @since 2020-06-15
 */
public class MergeSort {

    public static void mergeSort(int[] a) {
        int len = a.length - 1;

        split(a, 0, len);
    }

    public static void split(int[] a, int left, int right) {


        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;


        split(a, left, mid);
        split(a, mid + 1, right);

        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {

        int[] tmp = new int[right - left + 1];

        int k = 0;

        int l = left;
        int r = mid + 1;




        while (l <= mid && r <= right){

            if (a[l] < a[r]){
                tmp[k++] = a[l++];
            }else {
                tmp[k++] = a[r++];
            }

        }

        while (l <= mid){
            tmp[k++] = a[l++];
        }

        while (r <= right){
            tmp[k++] = a[r++];
        }


        for (int i = 0; i < tmp.length; i++) {
            a[left + i] = tmp[i];
        }
    }




    public static void main(String[] args) {
        int[] a = {3, 4, 1, 5, 7, 2};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
