package com.wxy.learn.practice.think.dynamic;

import java.util.Arrays;

/**
 * 找零钱
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * leetCode解法: https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 *
 * @author wangxiayun
 * @since 2020/7/27
 **/
public class coinChange {

    /**
     * 解法一： 搜索回溯 (超时间限制)
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    }

    public static int coinChange(int indexCoin, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (indexCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[indexCoin];
            int minCost = Integer.MAX_VALUE;

            for (int i = 0; i <= maxVal; i++) {
                int res = coinChange(indexCoin + 1, coins, amount - i * coins[indexCoin]);
                if (res != -1) {
                    minCost = Math.min(minCost, res + i);
                }
            }

            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }

        return -1;
    }



    /**
     * 解法二： 动态规划 (自上而下决策树)
     *
     * @param coins
     */
    public static int coinChange2(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange2(coins, amount, new int[amount]);
    }
    public static int coinChange2(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }

        if (rem == 0) {
            return 0;
        }

        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = coinChange2(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }

        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }



    /**
     *  解法三: 动态规划 (自下而上dp数组)
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange3(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, max);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        System.out.println(coinChange3(coins, 6));
    }
}
