package com.wxy.learn.practice.array.leetcode;

import java.util.*;

/**
 * 三数之和 (Mid)
 * https://leetcode-cn.com/problems/3sum/
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * @author wangxiayun
 * @since 2020/3/26
 **/
public class ThreeNumSum {

    /**
     * HashMap法
     * T: O(n^2)
     * S: O(n)
     *
     * 两数之和的变形，相当于a + b = - c
     * 利用了HashMap的containsKey时间复杂度为O(1)的特性
     *
     * Tip: 不能保证去重,复杂度过高
     *
     * @param a
     * @return
     */
    public static List<List<Integer>> threeNumSum(int[] a) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(a.length);
        for (int i = 0; i < a.length; i++) {
            int target = -a[i];
            map.put(target, i);
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (map.containsKey(a[i] + a[j]) &&
                        map.get(a[i] + a[j]) != i &&
                        map.get(a[i] + a[j]) != j) {
                    lists.add(Arrays.asList(a[i], a[j], -(a[i] + a[j])));
                }
            }
        }
        return lists;
    }

    /**
     * 力扣解法
     * T: O(n^2)
     * S: O(n)
     * 先排序，利用双指针
     *
     * @param a
     * @return
     */
    public static List<List<Integer>> threeNum(int[] a) {
        List<List<Integer>> list = new ArrayList<>();
        if (a == null || a.length < 3) {
            return list;
        }
        /**
         * 排序
         */
        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            /**
             * 没有小于0的数则三数之和大于0
             */
            if (a[i] > 0) {
                return list;
            }

            if (i > 0 && a[i] == a[i - 1]) {
                continue;
            }

            int L = i + 1;
            int R = a.length - 1;

            while (L < R) {
                int sum = a[L] + a[R] + a[i];
                if (sum == 0) {
                    list.add(Arrays.asList(a[L], a[i], a[R]));
                    while (L < R && a[L] == a[L + 1]) {
                        L++;
                    }
                    while (L < R && a[R] == a[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;

                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }

            }

        }
        return list;

    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -9, -4,9};
        System.out.println(threeNum(a));
    }
}
