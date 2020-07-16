package com.wxy.learn.practice.graph.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿的数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 *
 * @author wxy
 * @since 2020-07-11
 */
public class IslandCounts {


    /**
     * leetcode解法1: 深度优先遍历 T（O MN）M棋盘行数，N棋盘列数 S（O MN）
     *
     * @param grid
     * @return
     */
    public int islandCount(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int islandCount = 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    ++islandCount;
                    dfs(grid, r, c);
                }
            }

        }

        return islandCount;

    }


    /**
     * leetcode解法2：广度优先遍历 T(O MN) S(O min(M,N))
     *
     * @return
     */
    public int islandCount2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        int islandCounts = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    ++islandCounts;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);

                    while (!neighbors.isEmpty()) {
                        Integer id = neighbors.remove();

                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }

                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }

                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }

                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }

                    }
                }
            }
        }

        return islandCounts;
    }


    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        /**
         * 遇到以下情况终止
         */
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        /**
         * 置0，避免重复
         */
        grid[r][c] = 0;

        /**
         * 上下左右移动棋盘
         */
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
