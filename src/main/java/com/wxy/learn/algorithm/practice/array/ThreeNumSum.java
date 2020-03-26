package com.wxy.learn.algorithm.practice.array;

import java.util.*;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * @author wangxiayun
 * @since 2020/3/26
 **/
public class ThreeNumSum {

    /**
     * HashMap法 n^2
     * 不能保证去重
     * 复杂度过高
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

            int L = 0;
            int R = a.length - 1;

            while (L < R) {
                int sum = a[L] + a[R] + a[i];
                if (sum == 0 && i != L && i != R) {
                    list.add(Arrays.asList(a[L], a[R], a[i]));
                    while (a[L] == a[L + 1]) {
                        L++;
                    }
                    while (a[R] == a[R - 1]) {
                        R--;
                    }
                } else if (sum > 0) {
                    R--;
                } else if (sum < 0) {
                    L++;
                }
                L++;
                R--;
            }

        }
        return list;

    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -9, -4};
        System.out.println(threeNum(a));
    }
}
