package com.wxy.learn.algorithm.search;

/**
 * 二分查找---查找第一个值等于给定值的元素
 * 较易理解
 */
public class FindFirstEquals2 {

    public static int bsearch(int[] a,  int value) {
        int low = 0;
        int n = a.length;
        int high = n - 1;

        while (low <= high){
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value){
                high = mid -1;
            }
            else if (a[mid] < value){
                low = mid + 1;
            }
            else {
                if ((mid == 0) || (a[mid - 1] != value)){
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
        }

        return -1;

    }


    public static void main(String[] args) {
        int[] a = {1,2 ,3,8,8,8,9};
            System.out.println(bsearch(a, 8));
    }
}
