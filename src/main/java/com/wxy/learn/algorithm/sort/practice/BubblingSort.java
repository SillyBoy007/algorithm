package com.wxy.learn.algorithm.sort.practice;

import java.util.Arrays;

/**
 * @author admin
 */
public class BubblingSort extends BaseSort{

    public static void bubblingSort(int[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    BaseSort.swap(a, i, j);
                }
            }
        }
    }



    public static void main(String[] args) {
        int a[] = {8, 2, 1, 4, 5, 6, 3};
        bubblingSort(a);
        System.out.println(Arrays.toString(a));
    }
}
