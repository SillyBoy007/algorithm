package com.wxy.learn.practice.str.leetcode;


import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * @author wangxiayun
 * @since 2020/6/28
 **/
public class ReverseWord {

    /**
     * 我的题解 T(On) S(On)
     *
     * @param s
     * @return
     */
    public static String myReverseWorld(String s) {
        String[] split = s.split(" ");
        int left = 0;
        int right = split.length - 1;
        while (left <= right) {
            swap(left, right, split);
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]);
            sb.append(" ");
        }
        return sb.toString();
    }


    /**
     * leetCode题解1: 工具类  T（On） S（On）
     *
     * @param s
     * @return
     */
    public static String reverseWord1(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    /**
     * leetCode题解: 双端队列 T(On) S(On)
     *
     * @param s
     * @return
     */
    public static String reverseWord2(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                deque.offerFirst(word.toString());
                word.setLength(0);
            }else if (c != ' '){
                word.append(c);
            }
            ++left;
        }

        deque.offerFirst(word.toString());
        return String.join(" ", deque);
    }


    public static void swap(int a, int b, String[] s) {
        String tmp = s[b];
        s[b] = s[a];
        s[a] = tmp;
    }

    public static void main(String[] args) {
        String s = "I am smart boy";
        System.out.println(reverseWord2(s));
    }
}
