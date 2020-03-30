package com.wxy.learn.algorithm.practice.array.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *  https://leetcode-cn.com/problems/majority-element/
 * @author wangxiayun
 * @since 2020/3/26
 **/
public class MajorityElement {

    /**
     * 方法一: leetCode HashMap方法
     * 找出元素多于数组长度1/2的元素
     *
     * @param
     */
    public static int majorityElement(int[] a) {
        Map<Integer, Long> map = Arrays.stream(a).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long limit = a.length >> 1;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > limit) {
                return entry.getKey();
            }
        }
        return -1;
    }


    /**
     * 方法二:数组排序法(有问题)
     * 确定数组中有出现次数> ⌊ n/2 ⌋的元素，那排好序之后的数组中，相同元素总是相邻的。
     * 即存在长度> ⌊ n/2 ⌋的一长串 由相同元素构成的连续子数组。
     * 举个例子：
     * 无论是1 1 1 2 3，0 1 1 1 2还是-1 0 1 1 1，数组中间的元素总是“多数元素”，毕竟它长度> ⌊ n/2 ⌋。
     *
     * @param a
     * @return
     */
    public static int sort(int[] a) {
        Arrays.sort(a);
        return a[a.length >> 1];
    }

    /**
     * 方法三:摩尔投票法(推荐) On
     * <p>
     * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
     * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，cand_num即为最终答案。
     * <p>
     * 为何这行得通呢？
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     *
     * @param
     */

    public static int moleVote(int[] a) {
        int ticket = 1;
        int voter = a[0];
        for (int i = 1; i < a.length; i++) {
            if (voter == a[i]) {
                ticket++;
            } else {
                ticket--;
            }

            if (ticket <= 0) {
                voter = a[i];
                ticket = 1;
            }
        }
        return voter;
    }


    public static void main(String[] args) {
        int[] a = {1, 7, 2, 7, 3, 7, 4, 7, 5, 7, 7};
        System.out.println(moleVote(a));
    }

}
