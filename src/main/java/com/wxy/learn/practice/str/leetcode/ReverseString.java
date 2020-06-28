package com.wxy.learn.practice.str.leetcode;

import java.util.Arrays;

/**
 * 翻转字符串
 *
 * @author wangxiayun
 * @since 2020/6/28
 **/
public class ReverseString {
    /**
     * 解法一:双指针 T(On/2) S(O1)
     */

    public static void reverseStr1(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left <= right) {
            swap(s,left,right);
            left++;
            right--;
        }
    }

    public static void reverseStr2(char[] s){
        recu(s,0,s.length-1);
    }

    private static void recu(char[] a,int left,int right){
        if (left >= right){
            return;
        }
        swap(a,left,right);
        recu(a,++left,--right);
    }


    public static void swap(char[] a,int x,int y){
        char tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o', 'w'};
        reverseStr2(s);
        System.out.println(Arrays.toString(s));
    }
}
