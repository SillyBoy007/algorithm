package com.wxy.learn.practice.array.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和 (Easy)
 * https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * @author wangxiayun
 * @since 2020/3/26
 **/
public class TwoNumSum {

    /**
     * 暴力遍历
     * T: O(n^2)
     * S: O(n)
     *
     * @param a
     * @param target
     * @return
     */
    public static int[] twoNumSum(int[] a, int target) {
        int count = 0;
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            for (; j >= 0; j--) {
                System.out.println("循环次数" + (++count));
                if (target == a[i] + a[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;

    }

    /**
     * 利用哈希Map解法
     * S: O(n)
     * T: O(n)
     * 利用了HashMap的containsKey时间复杂度为O(1)的特性
     *
     * containsKey源码分析:
     * https://www.jianshu.com/p/06e2be54d4d6?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation
     *
     * @return
     */
    public static int[] hashTowSum(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], i);
            int num = target - a[i];
            //这里containsKey时间复杂度是O(1)
            if (map.containsKey(num) && map.get(num) != i) {
                return new int[]{map.get(num),i};
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int[] a = {-3, 0, 1, 7, -1, -2};

        System.out.println(Arrays.toString(hashTowSum(a, 0)));
    }
}
