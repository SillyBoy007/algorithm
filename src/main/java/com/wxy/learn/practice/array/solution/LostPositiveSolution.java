package com.wxy.learn.practice.array.solution;

import java.util.Arrays;

/**
 * 缺失的正数
 *
 * @author wangxiayun
 * @since 2020/7/29
 **/
public class LostPositiveSolution {

    /**
     * 1. 排序解法 空间O1 时间On^2
     */
    public static int lostPositive(int[] a) {
        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 && a[i] + 1 != a[i + 1]) {
                return i;
            }
        }
        return a[a.length - 1] + 1;
    }


    /**
     * 解法二 哈希表（以数组代替hash表）
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n+1;
            }
        }

        for (int i = 1; i < n; i++) {
            int abs = Math.abs(nums[i]);
            if (abs <= n) {
                nums[abs - 1] = -Math.abs(nums[abs - 1]);
            }
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    /**
     * 解法三:置换
     * @param
     */
    public static int firstMissingPositive2(int[] nums){
        int n = nums.length;
        for (int i = 0; i <n ; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                  int temp = nums[nums[i] - 1];
                  nums[nums[i] - 1] = nums [i];
                  nums[i] = temp;
            }
        }

        for (int i = 0; i < n ; i++) {
            if (nums[i] != i+1){
                return i + 1;
            }
        }
        return n + 1;

    }



    public static void main(String[] args) {
        int[] a = {-1, -3, 1, 3, 2, -2, -6};

        System.out.println(firstMissingPositive2(a));
    }
}
