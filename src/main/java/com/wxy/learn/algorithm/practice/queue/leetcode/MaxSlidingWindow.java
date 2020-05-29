package com.wxy.learn.algorithm.practice.queue.leetcode;

import java.util.Arrays;

/**
 * 滑动窗口最大值
 *
 * @author wxy
 * @since 2020-05-28
 */
public class MaxSlidingWindow {
    /**
     * 1.暴力穷举
     */

    public static int[] maxWindow(int[] nums, int k) {
        int n = nums.length;

        if (n * k == 0) {
            return new int[0];
        }

        int[] maxArray = new int[n - k + 1];
        for (int i = 0; i < maxArray.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i+k; j++) {
                max = Math.max(max,nums[j]);
            }

            maxArray[i] = max;
        }

        return maxArray;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(MaxSlidingWindow.maxWindow(nums,3)));
    }
}
