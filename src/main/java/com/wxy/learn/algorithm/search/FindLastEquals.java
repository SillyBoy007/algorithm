package com.wxy.learn.algorithm.search;

/**
 * 查找最后一个值等于给定值
 */
public class FindLastEquals {
    public static int findLast(int[] a,int value){
        int n = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (a[mid] > value){
                high = mid - 1;
            }else if (a[mid] < value){
                low = mid + 1;
            }else {
                if ((mid == n-1) || (a[mid+1] != value)){
                    return mid;
                }else {
                    low =  mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,8,8,8,9};
        System.out.println(findLast(a,8));
    }
}
