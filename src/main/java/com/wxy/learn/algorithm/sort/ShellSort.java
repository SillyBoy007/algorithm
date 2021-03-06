package com.wxy.learn.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔 (O n3/2) 稳定 原地排序
 * @author wxy
 */
public class ShellSort {
    public static void shellSort(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return;
        }
        int count = 0;

        int step = len / 2;
        while (step >= 1) {
            for (int i = step; i < len; i++) {
                int value = arr[i];
                int j = i - step;
                for (; j >= 0; j = j - step) {
                    System.out.println("第"+ ++count+"次循环:"+ Arrays.toString(arr));

                    if (value < arr[j]) {
                        arr[j+step] = arr[j];
                    }
                    else {
                        break;
                    }

                }
                arr[j+step] = value;
            }

            step = step / 2;

        }
    }


    public static void main(String[] args) {
        int [] arr = {4,5,6,3,2,1};
        shellSort(arr);
       // System.out.println(Arrays.toString(arr));
    }
}
