package com.wxy.learn.algorithm.practice.array;

import java.util.Arrays;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * @author wangxiayun
 * @since 2020/3/26
 **/
public class TwoNumSum {

    public static int[] twoNumSum(int[] a, int target) {
       int count = 0;
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            for (; j >= 0; j--) {
                System.out.println("循环次数"+(++count));
                if (target == a[i] + a[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;

    }

    public static int[] twoSum(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println("循环次数"+(++count));
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }



    public static void main(String[] args) {
        int[] a = {-3, 0, 1, 7, -1, -2};

        System.out.println(Arrays.toString(twoSum(a, 0)));
    }
}
