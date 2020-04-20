package com.wxy.learn.note.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划-斐波那契数列
 *
 * @author wangxiayun
 * @since 2020/4/16
 **/
public class Fib {

    static int fb(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return fb(n - 1) + fb(n - 2);
    }


    /**
     * 带备忘录的递归法 解决重复构造子
     */
    static int fbMemo(int n) {
        if (n < 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(n, 0);
        return helper(map, n);
    }

    static int helper(Map<Integer, Integer> map, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if (map.get(n) != null) {
            return map.get(n);
        }
        map.put(n, helper(map, n - 1) + helper(map, n - 2));
        return map.get(n);
    }


    /**
     * dp 数组的迭代解法 状态转移方程式
     */

    static int dpFib(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 1);

        for (int i = 3; i <= n; i++) {
            memo.put(i, memo.get(i - 1) + memo.get(i - 2));
        }

        return memo.get(n);
    }


    /**
     * dp数组进一步优化，空间复杂度降为1
     */

    static int dpFibMax(int n) {
        if (n == 2 || n == 1) {
            return 1;
        }
        int prev = 1,curr = 1;
        for (int i = 3; i <= n ; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }

        return curr;
    }


}
