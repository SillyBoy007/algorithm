package com.wxy.learn.practice.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author wxy
 * @since 2020-06-03
 */
public class ChooseSort {
    public static void chooseSort(int[] a) {
        int n = a.length;

        if (n <= 1) {
            return;
        }

        for (int i = 0; i <n ; i++) {
            int min = findMinIndex(a,i);
            swap(a,i,min);
        }

    }


    public static int findMinIndex(int[] a, int start) {
        int minIndex = start;
        for (int i = start; i < a.length; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void swap(int[] a,int x,int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args) {
        int [] a = {3,4,1,5,7,2};
        chooseSort(a);
        System.out.println(Arrays.toString(a));
    }
}
