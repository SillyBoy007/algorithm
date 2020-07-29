package com.wxy.learn.practice.think.dynamic;

/**
 * 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * @author wangxiayun
 * @since 2020/7/24
 **/
public class MinPathSum {
    /**
     * 当 i>0i>0 且 j=0j=0 时，\textit{dp}[i][0]=\textit{dp}[i-1][0]+\textit{grid}[i][0]dp[i][0]=dp[i−1][0]+grid[i][0]。
     * 当 i=0i=0 且 j>0j>0 时，\textit{dp}[0][j]=\textit{dp}[0][j-1]+\textit{grid}[0][j]dp[0][j]=dp[0][j−1]+grid[0][j]。
     * 当 i>0i>0 且 j>0j>0 时，\textit{dp}[i][j]=\min(\textit{dp}[i-1][j],\textit{dp}[i][j-1])+\textit{grid}[i][j]dp[i][j]=min(dp[i−1][j],dp[i][j−1])+grid[i][j]。
     */

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }


        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1] + grid[i][j]);
            }
        }

        return dp[rows - 1][cols - 1];


    }
}
