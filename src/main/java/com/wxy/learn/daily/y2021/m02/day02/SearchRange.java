package com.wxy.learn.daily.y2021.m02.day02;

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
public class SearchRange{


    public static int[] solution(int[] nums, int target) {
        int left = findFirstPosition(nums,target);
        int right = findLastPosition(nums,target);
        return new int[]{left,right};
    }


    public static int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }


    private static int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    /**
     * 2.常规解法
     * T O(n)
     * S O1
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution2(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }


        int[] a = new int[]{-1, -1};

        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                if (a[0] == -1) {
                    a[0] = i;
                }
                a[1] = i;
            }
        }

        return a;
    }

}
