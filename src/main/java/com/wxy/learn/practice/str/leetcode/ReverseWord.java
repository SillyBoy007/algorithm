package com.wxy.learn.practice.str.leetcode;


/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * @author wangxiayun
 * @since 2020/6/28
 **/
public class ReverseWord {

    public static String reverseWorld(String s) {
        String[] split = s.split(" ");
        int left = 0;
        int right = split.length - 1;
        while (left <= right){
            swap(left,right,split);
            left ++;
            right --;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length ; i++) {
            sb.append(split[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void swap(int a,int b,String[] s){
        String tmp = s[b];
        s[b] = s[a];
        s[a] = tmp;
    }

    public static void main(String[] args) {
        String s = "I am smart boy";
        System.out.println(reverseWorld(s));
    }
}
