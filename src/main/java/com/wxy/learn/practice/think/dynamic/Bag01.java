package com.wxy.learn.practice.think.dynamic;

import java.util.Map;

/**
 * 背包问题 - 动态规划法
 * 参考链接: https://www.cnblogs.com/mqk100/p/11319417.html
 * 背包九讲 https://www.kancloud.cn/kancloud/pack/70125
 *
 * @author wangxiayun
 * @since 2020/7/21
 **/
public class Bag01 {
    public static int getMaxValue(int[] weight, int[] value, int w, int n) {
        int[][] table = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            /**
             * 背包大小
             */
            for (int j = 1; j <= w; j++) {
                /**
                 * 当前物品i重量比背包j大,不装
                 */
                if (weight[i] > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    /**
                     * 装得下,Max{不装物品i,装物品i}
                     */

                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - weight[i]] + value[i]);
                }
            }

        }

        return table[n][w];
    }


    public static void main(String[] args) {
        int n = 5;
        int w = 10;
        /**
         * 物品的重量
         */
        int[] weight = {0, 2, 2, 6, 5, 4};    //各个物品的重量

        /**
         * 背包内物品的价值
         */
        int[] value = {0, 6, 3, 5, 4, 6};     //各个物品的价值


        System.out.println(getMaxValue(weight, value, w, n));
    }
}
