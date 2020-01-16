package com.wxy.learn.algorithm.sort.practice;

public abstract class BaseSort {
    protected static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
