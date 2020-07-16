package com.wxy.learn.practice.graph.leetcode;

import java.util.HashMap;

/**
 * 有效的数独
 * <p>
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 *
 * @author wxy
 * @since 2020-07-16
 */
public class EffectiveSudoku {

    public boolean isSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = Integer.valueOf(num);
                    int boxIndex = (i / 3) * 3 + j / 3;
                    /**
                     * 同一行是否有相同的数字
                     */
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    /**
                     * 同一列是否有相同的数字
                     */
                    cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);

                    /**
                     * 3*3单元格内是否有相同的数字
                     */
                    boxes[boxIndex].put(n, boxes[boxIndex].getOrDefault(n, 0) + 1);
                    if (rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxes[boxIndex].get(n) > 1) {
                        return false;
                    }

                }
            }
        }
        return true;
    }


}
