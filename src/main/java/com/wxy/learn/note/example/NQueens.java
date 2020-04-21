package com.wxy.learn.note.example;

import java.util.Date;

/**
 * 回溯---N皇后
 *
 * @author wangxiayun
 * @since 2020/4/20
 **/
public class NQueens {

    private static final short N = 8;
    private static int count = 0;

//回溯算法解题框架
//    result = []
//    def backtrack(路径, 选择列表):
//            if 满足结束条件:
//            result.add(路径)
//            return
//
//            for 选择 in 选择列表:
//    做选择
//    backtrack(路径, 选择列表)
//    撤销选择
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
