package com.wxy.learn.algorithm.search;

/**
 * 二分递归实现
 */
public class BinarySearchRecursion {
    public static int binarySearch(int[] a, int value) {
        return search(a, 0, a.length - 1, value);
    }

    public static int search(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;

        if (a[mid] == value) {
            return mid;
        }
        if (a[mid] < value) {
            return search(a, mid + 1, high, value);
        } else {
            return search(a, low, mid - 1, value);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(binarySearch(a, 3));
    }
}
