package com.wxy.learn.note.example;

import java.util.Date;

/**
 * 回溯---N皇后
 *
 * @author wangxiayun
 * @since 2020/4/20
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

    private static final short N = 8;
    private static int count = 0;

    private static void putQueenAtRow(short[][] chess, int row) {

        /**
         * base case
         * 递归结束条件.打印棋盘
         */
        if (row == N) {
            count++;
            System.out.println("第" + count + "种解");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(chess[i][j] + "   ");
                }
                System.out.println();
            }
            return;
        }



        /**
         * 安全的摆放皇后
         */

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //摆放这一行的皇后，之前要清掉所有这一行摆放的记录，防止污染棋盘
                chess[row][j] = 0;
            }
            chess[row][i] = 1;

            if (isSafety(chess, row, i)) {
                putQueenAtRow(chess, row + 1);
            }
        }
    }

    private static boolean isSafety(short[][] chess, int row, int col) {
        int step = 1;

        while (row - step >= 0) {
            //中上
            if (chess[row - step][col] == 1) {
                return false;
            }
            //左上
            if (col - step >= 0 && chess[row - step][col - step] == 1) {
                return false;
            }
            //右上
            if (col + step < N && chess[row - step][col + step] == 1) {
                return false;
            }
            step++;
        }
        return true;

    }

    public static void main(String[] args) {
        Date begin =new Date();

        short chess[][] =new short[N][N];
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <N ; j++) {
                chess[i][j] = 0;
            }
        }

        putQueenAtRow(chess,0);
        Date end =new Date();
        System.out.println("解决 " +N+ " 皇后问题，用时：" +String.valueOf(end.getTime()-begin.getTime())+ "毫秒，计算结果："+count);

    }

}
