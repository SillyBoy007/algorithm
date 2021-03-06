package com.wxy.learn.algorithm.search;

public class BinarySearch {
    public static int binarySearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }


    public static int binarySearch2(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > target){
                high = mid - 1;
            }else if (a[mid] < target){
                low = mid + 1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(binarySearch2(a, 3));
    }
}
