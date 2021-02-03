package com.wxy.learn.daily.y2021.m02.day02;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 *
 * @author wxy
 * @since 2021-02-02
 */
public class SearchRange {

    public static int[] solution(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }


        int[] a = new int[]{-1, -1};

        for (int i = 0; i < len; i++) {
            if (nums[i] == target){
                if (a[0] == -1){
                    a[0] = i;
                }
                a[1] = i;
            }
        }

        return a;
    }
}
