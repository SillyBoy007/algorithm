package com.wxy.learn.practice.sort;

import java.util.Arrays;

/**
 * @author wxy
 * @since 2020-12-28
 */
public class SortPractice {
    public static void bubbleSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = i + 1; j < len; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                    flag = false;
                }

            }

            if (flag) {
                break;
            }
        }
    }

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

    public static void shellSort(int[] a) {
        int len = a.length;
        int step = a.length / 2;

        while (step >= 1) {

            for (int i = step; i < len; i = i + step) {
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

    public static void chooseSort(int[] a) {
        int len = a.length;

        for (int i = 0; i < len; i++) {
            int min = findMinIndex(a, i);
            swap(a, i, min);
        }

    }

    public static void mergeSort(int[] a) {
        split(a, 0, a.length - 1);
    }

    public static void quickSort(int[] a) {
        quick(a, 0, a.length - 1);
    }
    private static void quick(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(a, left, right);

        quick(a, left, p - 1);
        quick(a, left, p + 1);
    }

    private static int partition(int[] a, int left, int right) {
        int pivot = a[right];
        int i = left;
        for (int j = left; j < a.length; j++) {
            if (a[j] < pivot){
                if (i == j){
                    i++;
                }else {
                    swap(a,i,j);
                    i++;
                }
            }
        }
        swap(a,i,right);
        return pivot;
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
        int[] tmp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int k = 0;
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
            a[i + left] = tmp[i];
        }


    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int findMinIndex(int[] a, int start) {
        int minIdx = start;
        for (int i = start; i < a.length; i++) {
            if (a[i] < a[minIdx]) {
                minIdx = i;
            }
        }

        return minIdx;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 6, 7, 8, 9, 2, 4, 3, 0};

        mergeSort(a);

        System.out.println(Arrays.toString(a));
    }

}
