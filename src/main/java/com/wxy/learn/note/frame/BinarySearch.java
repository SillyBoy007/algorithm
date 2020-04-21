package com.wxy.learn.note.frame;

/**
 * 二分查找
 *
 * @author wangxiayun
 * @since 2020/4/20
 **/
public class BinarySearch {

    public static boolean binarySearch(int data, int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] == data) {
                return true;
            } else if (a[mid] < data) {
                left = mid + 1;
            } else if (a[mid] > data) {
                right = mid - 1;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        System.out.println(binarySearch(0,a));
    }
}

