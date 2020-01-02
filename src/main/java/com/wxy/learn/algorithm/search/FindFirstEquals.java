package com.wxy.learn.algorithm.search;

/**
 * 二分查找---查找第一个值等于给定值的元素
 * 简洁，理解起来却非常烧脑，也很容易写错
 */
public class FindFirstEquals {
    public static int bsearch(int[] a, int value) {

        int n = a.length ;
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + (high - low)/2 ;
            if (a[mid] >= value){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        if (low < n && a[low] == value ){
            return low;
        }
        else {
            return -1;
        }
    }



    public static void main(String[] args) {
        int[] a = {1, 2, 3,8,8,8,9};
        System.out.println(bsearch(a, 8));
    }
}
