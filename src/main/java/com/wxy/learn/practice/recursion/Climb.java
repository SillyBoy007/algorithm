package com.wxy.learn.practice.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。
 * 你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author wangxiayun
 * @since 2020/6/1
 **/
public class Climb {

    public static int climbMain(int n) {
        return climb(0, n);
    }

    /**
     * 暴力递归 (T（O2^n） S(On))
     *
     * @param i
     * @param n
     * @return
     */
    public static int climb(int i, int n) {

        if (n == 0) {
            return 0;
        }

        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        return climb(i + 1, n) + climb(i + 2, n);

    }


    public static int climbMain2(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return climb2(0, n, map);
    }

    /**
     * 记忆递归 T(On) S(On)
     *
     * @param i
     * @param n
     * @return
     */
    public static int climb2(int i, int n, Map<Integer, Integer> map) {
        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        Integer cache = map.get(i);

        if (Objects.nonNull(cache)) {
            return cache;
        }

        int ret = climb2(i + 1, n, map) + climb2(i + 2, n, map);

        map.put(i, ret);
        return ret;
    }


    /**
     * 动态规划 T(On) S(On)
     *
     * @param n
     * @return
     */
    public static int climb3(int n) {

        if (n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


    public static int climb4(int n) {
       if (n == 1){
           return 1;
       }

       if (n == 2){
           return 2;
       }
        int s1 = 1;
        int s2 = 2;
        for (int i = 3; i <= n; i++) {
            int s3 = s1 + s2;
            s1 = s2;
            s2 = s3;
        }
        return s2;
    }


    public static int climbMain3(int n) {
        return climb3(n);
    }


    public static int climbMain4(int n) {
        return climb4(n);
    }


    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        System.out.println(climbMain(35));
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        System.out.println(climbMain2(35));
        System.out.println(System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        System.out.println(climbMain3(35));
        System.out.println(System.currentTimeMillis() - start3);

        long start4 = System.currentTimeMillis();
        System.out.println(climbMain4(35));
        System.out.println(System.currentTimeMillis() - start4);


    }
}
