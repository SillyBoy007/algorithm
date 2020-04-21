package com.wxy.learn.note.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划---凑零钱问题
 *
 * @author wangxiayun
 * @since 2020/4/21
 **/
public class CoinChange {

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
        return dp(amount, coins);
    }


    /**
     * 暴力穷举
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


    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>();

        coins.add(1);
        coins.add(2);
        coins.add(5);


        System.out.println(CoinChange.coinChange(coins,7));
    }
}
