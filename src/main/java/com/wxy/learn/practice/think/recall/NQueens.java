package com.wxy.learn.practice.think.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯算法解题N皇后
 * 参考 https://blog.csdn.net/folkboat/article/details/103308926
 * @author wangxiayun
 * @since 2020/7/20
 **/


//回溯解题框架
//    void backtrack(resultStack, arg1, arg2, ...){
//        // 当满足题目的某种要求时，说明此时找到了问题的一个解
//        if (some condition){
//            // 在这里根据题目要求做出相关操作
//            // 这里的操作一般是将resultStack复制一份，加入到所有解的集合中
//            some operations;
//
//            // 直接返回
//            return;
//        }
//
//        // candidates 表示"要求2"中提到的多种候选决策
//        // 在这里通过for循环遍历所有的候选决策
//        for (candidate : candidates){
//            // 当候选条件不符合要求时，跳过这个条件
//            if (candidate does not satisfy some requirements){
//                continue;
//            }
//
//            // 下面三行是这个函数的核心，体现了回溯算法能进则进的思想
//            // 先把当前候选条件加入结果栈中，然后进入下一步，
//            // 从下一步中返回后，将当前候选条件出栈，把结果栈恢复到之前的状态，
//            // 以便考虑下一个candidate（for循环的下一个元素）
//            resultStack.push(candidate);
//            backtrack(resultStack, arg1, arg2);
//            resultStack.pop();
//        }
//    }

public class NQueens {
    /***
     * 棋盘
     */
    private char[][] board;
    /**
     * N皇后
     */
    private int N;
    /**
     * 解决方案集合
     */
    private List<List<String>> solutions = new ArrayList<>();


    //主函数
    public List<List<String>> solveNqueens(int n) {
        this.N = n;
        /**
         * 1.初始化棋盘,所有的单元格设置为'.',表示棋盘为空
         */
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0);
        return solutions;
    }

    /**
     * 递归
     *
     * @param usedCols       使用过的列号，0开始
     * @param usedDiagonals1 使用过的 方向左上到右下的斜线
     * @param usedDiasonals2 使用过的 方向右上到左下的斜线号
     * @param row
     */
    public void backtrack(List<Integer> usedCols, List<Integer> usedDiagonals1, List<Integer> usedDiasonals2, int row) {
        /**
         * 行号为N ， 说明所有行都已经摆放有解了
         */
        if (row == N) {
            addSolution();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (usedCols.contains(i) || usedDiagonals1.contains(row - i) || usedDiasonals2.contains(row + i)) {
                continue;
            }

            board[row][i] = 'Q';
            usedCols.add(i);
            usedDiagonals1.add(row - i);
            usedDiasonals2.add(row + i);
            backtrack(usedCols, usedDiagonals1, usedDiasonals2, row + 1);
            board[row][i] = '.';
            usedCols.remove(usedCols.size() - 1);
            usedDiagonals1.remove(usedDiagonals1.size() - 1);
            usedDiasonals2.remove(usedDiasonals2.size() - 1);

        }
    }

    public void addSolution() {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < N; j++) {
                builder.append(board[i][j]);
            }
            solution.add(builder.toString());
        }
        solutions.add(solution);
    }

}
