package com.wxy.learn.daily.y2021.m01.day27;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author wxy
 * @since 2021-01-26
 */
public class IsPalindromeSolution {

    /**
     * 反转一半数字
     * T：O(Logn)
     * S: O(1)
     *
     * x%10表示 取末尾余数
     * x/10表示 舍去末尾的数
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertNumber = 0;
        while (x > revertNumber) {
            revertNumber = revertNumber * 10 + x % 10;
            x = x / 10;
        }

        return x == revertNumber || x == revertNumber / 10;
    }

}
