package com.wxy.learn.daily.y2021.m02.day03;

/**
 * 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author wxy
 * @since 2021-02-03
 */
public class RemoveDuplicates{
    public static int solution(int[] nums) {
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[j] != nums[i]){
                j++;
                nums[j] = nums[i];
            }
        }

        return j+1;

    }
}
