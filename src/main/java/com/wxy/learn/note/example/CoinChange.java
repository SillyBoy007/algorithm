package com.wxy.learn.note.example;

import java.util.*;

/**
 * 动态规划---凑零钱问题
 *
 * @author wangxiayun
 * @since 2020/4/21
 **/
public class CoinChange {

    private static int count = 0;

//    # 伪码框架
//    def coinChange(coins: List[int], amount: int):
//            # 定义：要凑出金额 n，至少要 dp(n) 个硬币
//    def dp(n):
//            # 做选择，选择需要硬币最少的那个结果
//        for coin in coins:
//    res = min(res, 1 + dp(n - coin))
//            return res
//    # 我们要求的问题是 dp(amount)
//    return dp(amount)

    private static int coinChange(List<Integer> coins, Integer amount) {
        return memodp(amount, coins);
    }


    /**
     * 暴力穷举
     *
     * @param n
     * @param coins
     * @return
     */
    private static int dp(int n, List<Integer> coins) {

        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;

        for (Integer coin : coins) {
            int subProblem = dp(n - coin, coins);
            //子问题无解，跳过
            if (subProblem == -1) {
                continue;
            }
            res = Integer.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;

    }

    /**
     * 备忘录
     *
     * @param
     */
    private static int memodp(int n, List<Integer> coins) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> memo = new HashMap<>();
        if (memo.get(n) != null) {
            return memo.get(n);
        }

        for (Integer coin : coins) {
            int subProblem = memodp(n - coin, coins);
            if (subProblem == -1) {
                continue;
            }
            res = Integer.min(subProblem + 1, res);
        }

        res = Objects.equals(res, Integer.MAX_VALUE) ? -1 : res;

        memo.put(n, res);
        return res;

    }


    /**
     * dp数组
     *
     * @param
     */

    public static int dpChange(List<Integer> coins, int amount) {
        // 数组大小为 amount + 1，初始值也为 amount + 1
        Integer[] dp = new Integer[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount;
        }
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (Integer coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Integer.min(dp[i], dp[i - coin] + 1);

            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>();

        coins.add(1);
        coins.add(2);
        coins.add(5);


        System.out.println(CoinChange.dpChange(coins, 5));
    }
}
