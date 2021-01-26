package com.wxy.learn.daily.y2021.m01.day01;

/**
 * 剑指 Offer 04.二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 链接：https://leetcode-cn.com/leetbook/read/illustrate-lcof/xs5w4d/
 *
 * @author wxy
 * @since 2021-01-22
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int col = matrix.length - 1;
        int row = 0;
        while (col >= 0 && row < matrix[0].length) {
            if (matrix[col][row] == target) {
                return true;
            } else if (matrix[col][row] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
