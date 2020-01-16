package com.wxy.learn.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author wxy
 */
public class InsertSort {

    public static void insertSort(int[] arr, int size) {
        if (size <= 1) {
            return;
        }
        int count = 0;

        for (int i = 1; i < size; i++) {
            int value = arr[i];
            int j = i - 1;

            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
            System.out.println("第"+ ++count+"次循环:"+ Arrays.toString(arr));

        }
    }


    /**
     * 插入排序（插入位置，从头至尾搜索）
     * 查询插入位置时， 从头至尾搜索
     * @param data
     */
    private static void fromStartToEnd(int[] data) {
        int count = 0;

        for (int i=1; i < data.length; i++) {
            int value = data[i];

            int[] tmp = new int[2];

            int change = i;
            for (int j=0; j < i; j++) {
                System.out.println("第"+ ++count+"次循环:"+ Arrays.toString(data));

                if(value >= data[j]) {
                    continue;
                }

                int index = j%2;
                if (change == i) {
                    tmp[Math.abs(index-1)] = data[j];
                    change = j;
                }
                tmp[index] = data[j+1];
                if (0 == index) {
                    data[j+1] = tmp[index+1];
                } else {
                    data[j+1] = tmp[index-1];
                }
            }
            data[change] = value;

        }
    }

    public static void main(String[] args) {
        int [] arr = {4,5,6,3,2,1};
        fromStartToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }
}
