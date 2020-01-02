package com.wxy.learn.algorithm.search;

/**
 * 查找第一个大于给定值
 */
public class FindFirstGt {
    public static int findFirstGt(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < value) {
                low = mid + 1;
            }else if (a[mid] > value){
                high = mid - 1;
            }else {
                if (a[mid+1] != value){
                    return mid+1;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,4,5,6};
        System.out.println(findFirstGt(a,3));
    }
}
