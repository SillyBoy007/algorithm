package com.wxy.learn.algorithm.sort;

import java.util.Arrays;

/**
 * @author wxy
 * 希尔
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

                    if (value < arr[j]) {
                        arr[j+step] = arr[j];
                    } else {
                        break;
                    }

                }

                arr[j+step] = value;
                System.out.println("第"+ ++count+"次循环:"+ Arrays.toString(arr));

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
