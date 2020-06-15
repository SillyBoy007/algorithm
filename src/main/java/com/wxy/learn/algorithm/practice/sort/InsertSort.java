package com.wxy.learn.algorithm.practice.sort;


import java.util.Arrays;

/**
 * 插入排序
 *
 * @author wxy
 * @since 2020-06-03
 */
public class InsertSort {

    public static void insertSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int j = i-1;
            int tmp = a[i];
            for (; j >= 0 ; j--) {

                if (a[j] > tmp){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = tmp;

        }
    }


    public static void main(String[] args) {
        int[] a = {3, 4, 1, 5, 7, 2};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
