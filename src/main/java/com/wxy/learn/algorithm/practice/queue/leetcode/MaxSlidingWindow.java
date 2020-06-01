package com.wxy.learn.algorithm.practice.queue.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 滑动窗口最大值
 *
 * @author wxy
 * @since 2020-05-28
 */
public class MaxSlidingWindow {
    private static ArrayDeque<Integer> deque = new ArrayDeque<>();

    /**
     * 1.暴力穷举(时间O(n*k) 空间(On))
     */

    public static int[] maxWindow(int[] nums, int k) {
        int n = nums.length;

        if (n * k == 0) {
            return new int[0];
        }

        int[] maxArray = new int[n - k + 1];
        for (int i = 0; i < maxArray.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }

            maxArray[i] = max;
        }

        return maxArray;
    }

    private static void cleanQueue(int i, int k,int[] a) {
        if (!deque.isEmpty() && deque.getFirst() == i - k) {
            deque.removeFirst();
        }

        while (!deque.isEmpty() && a[i] > a[deque.getLast()]) {
            deque.removeLast();
        }
    }

    /**
     * 解法2:双端队列 (T(On) S(On))
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxWindow2(int[] nums, int k) {
        int n = nums.length;
        if (nums.length * k == 0) {
            return new int[0];
        }

        if (nums.length == 1) {
            return nums;
        }

        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            cleanQueue(i, k,nums);
            deque.addLast(i);

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int[] output = new int[n - k + 1];
        output[0] = nums[maxIndex];


        for (int i = k; i < n; i++) {
            cleanQueue(i, k,nums);
            deque.addLast(i);
            output[i - k + 1] = nums[deque.getFirst()];
        }
        return output;

    }

    /**
     * 解法三:动态规划 (T(On) S(On))
     * @param
     */

    public int[] maxWindow3 (int [] nums,int k){
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        int [] left = new int[n];
        left[0] = nums[0];
        int [] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) {
                left[i] = nums[i];  // block_start
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];  // block_end
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }

        return output;


    }



    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(MaxSlidingWindow.maxWindow2(nums, 3)));
    }
}

