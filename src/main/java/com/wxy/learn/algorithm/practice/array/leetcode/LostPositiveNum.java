package com.wxy.learn.algorithm.practice.array.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 缺失的第一个正数  https://leetcode-cn.com/problems/first-missing-positive/
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 要求:你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间(O1)
 *
 * @author wangxiayun
 * @since 2020/3/26
 **/
public class LostPositiveNum {
    /**
     * 排序的方法，时间复杂度较高，不符合要求
     *
     * @param a
     * @return
     */
    public static int lostPositiveNum(int[] a) {
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > 0 && (a[i] + 1 != a[i + 1])) {
                return a[i] + 1;
            }
        }
        return -1;
    }


    /**
     * leetCode解法一:哈希表遍历法（时间(O1) 空间(On)）
     *
     * @param a
     */
    public static int hashSetFind(int[] a) {
        int len = a.length;

        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }

        for (int i = 1; i < a.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return len + 1;
    }

    /**
     * leetCode解法二:二分查找(时间(Onlogn)  空间 (O1))
     * 这个思路需要先对数组排序，而排序使用的时间复杂度是 O(N \log N)O(NlogN)，是不符合这个问题的时间复杂度要求。
     *
     * @return
     */
    public static int binarySearchFind(int[] a) {
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (binarySearch(a, i) == -1) {
                return i;
            }
        }

        return a[a.length - 1] + 1;
    }

    private static int binarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == a[mid]) {
                return mid;
            } else if (target > a[mid]) {
                left = mid + 1;
            } else if (target < a[mid]) {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 最优解
     * leetCode解法三:将数组视为哈希表（时间(On) 空间(O1)）
     *
     *  while 循环不会每一次都把数组里面的所有元素都看一遍。如果有一些元素在这一次的循环中被交换到了它们应该在的位置，那么在后续的遍历中，由于它们已经在正确的位置上了，代码再执行到它们的时候，就会被跳过。
     最极端的一种情况是，在第 1 个位置经过这个 while 就把所有的元素都看了一遍，这个所有的元素都被放置在它们应该在的位置，那么 for 循环后面的部分的 while 的循环体都不会被执行。

     平均下来，每个数只需要看一次就可以了，while 循环体被执行很多次的情况不会每次都发生。这样的复杂度分析的方法叫做均摊复杂度分析。


     * @param a
     * @return
     */
    public static int hashFind(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            while (a[i] > 0 && a[i] <= len && a[a[i] - 1] != a[i]) {
                swap(a, a[i] - 1, i);
            }
        }

        for (int i = 0; i < len; i++) {
            if (a[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] a = {111,222,333};
        System.out.println(hashFind(a));
    }
}
