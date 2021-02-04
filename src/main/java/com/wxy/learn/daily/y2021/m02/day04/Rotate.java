package com.wxy.learn.daily.y2021.m02.day04;

import java.util.Arrays;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * link：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
 *
 * @author wxy
 * @since 2021-02-04
 */
public class Rotate {

    /**
     * 方法一：使用额外的数组
     * T: O(n)
     * S: O(n)
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];

        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }

        System.arraycopy(newArr, 0, nums, 0, n);

    }

    /**
     * 方法三：数组翻转
     * T：O（n）
     * S: O（1）
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0,nums.length -1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);

        System.out.println(Arrays.toString(nums));
    }
}
