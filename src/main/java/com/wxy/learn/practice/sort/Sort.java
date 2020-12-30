package com.wxy.learn.practice.sort;

import java.util.Arrays;

/**
 * @author wxy
 * @since 2020-12-24
 */
public class Sort {

    /**
     * 冒泡
     *
     * @param a
     */
    public static void bubbleSort(int[] a) {
        int len = a.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    /**
     * 插入
     *
     * @param a
     */
    public static void insertSort(int[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            int tmp = a[i];
            for (; j >= 0; j--) {
                if (a[j] > tmp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }

            a[j + 1] = tmp;
        }
    }

    /**
     * 希尔
     *
     * @param a
     */
    public static void shellSort(int[] a) {
        int len = a.length;
        int step = len / 2;

        while (step >= 1) {
            for (int i = 1; i < len; i++) {
                int j = i - step;
                int tmp = a[i];
                for (; j >= 0; j = j - step) {
                    if (a[j] > tmp) {
                        a[j + step] = a[j];
                    } else {
                        break;
                    }
                }
                a[j + step] = tmp;
            }
            step = step / 2;
        }
    }

    /**
     * 选择
     *
     * @param a
     */
    public static void chooseSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int minIdx = findMinIndex(a, i);
            swap(a, minIdx, i);
        }
    }

    /**
     * 归并
     *
     * @param a
     */
    public static void mergeSort(int[] a) {
        split(a, 0, a.length - 1);
    }

    private static void split(int[] a, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        split(a, left, mid);
        split(a, mid + 1, right);

        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        //申请数组空间，长度为左右差集
        int[] tmp = new int[right - left + 1];
        int k = 0;

        int l = left;
        int r = mid + 1;

        while (l <= mid && r <= right) {
            if (a[l] < a[r]) {
                tmp[k++] = a[l++];
            } else {
                tmp[k++] = a[r++];
            }
        }

        while (l <= mid) {
            tmp[k++] = a[l++];
        }


        while (r <= right) {
            tmp[k++] = a[r++];
        }


        for (int i = 0; i < tmp.length; i++) {
            a[left + i] = tmp[i];
        }
    }

    /**
     * 快速
     * @param a
     */
    public static void quick(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        int m = partition(a, left, right);

        sort(a, left, m - 1);
        sort(a, m + 1, right);
    }

    public static int partition(int[] a, int left, int right) {
        int pivot = a[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    swap(a, i, j);
                    i++;
                }
            }
        }

        swap(a, i, right);

        return i;
    }


    private static int findMinIndex(int[] a, int start) {
        int minIdx = start;
        for (int j = start; j < a.length; j++) {
            if (a[minIdx] > a[j]) {
                minIdx = j;
            }
        }
        return minIdx;
    }

    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 6, 7, 8, 9, 2, 4, 3, 0};

        quick(a);

        System.out.println(Arrays.toString(a));
    }
}
