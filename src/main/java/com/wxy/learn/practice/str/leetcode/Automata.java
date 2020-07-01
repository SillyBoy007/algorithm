package com.wxy.learn.practice.str.leetcode;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 *
 * @author wangxiayun
 * @since 2020/6/30
 **/
public class Automata {
    private int state = 0;
    private int [][] table = {{0,1,2,3},{3,3,2,3},{3,3,2,3},{3,3,3,3}};
    long ans = 0;
    int sign = 1;
    /**
     * leetCode解法一: 正常遍历 T(On) S(O1)
     *
     * @param str
     * @return
     */
    public static int stringToInt1(String str) {
        int i = 0;
        int n = str.length();

        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        if (i == n) {
            return 0;
        }
        int flag = 1;

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-') {
                flag = -1;
            }
            i++;
        }
        int ans = 0;

        while (i < n  && Character.isDigit(str.charAt(i))) {
            int tmp = str.charAt(i) - '0';
            if (flag == 1 && (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && tmp > 7))) {
                return Integer.MAX_VALUE;
            }

            if (flag == -1 && (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && tmp > 8))) {
                return Integer.MIN_VALUE;
            }
            ans = ans * 10 + tmp;

            i++;
        }
        return ans * flag;
    }

//    public static int gets(char c){
//        if (c == ' '){
//            return 0;
//        }
//
//        if (c == '+' || c == '-'){
//
//        }
//    }

    /**
     * leetCode解法二:自动机 T(On) S(On)
     * @param args
     */


    public static void main(String[] args) {
        String str = "  -12323saddsad2323d";

        System.out.println(stringToInt1(str));
    }
}
