package com.wxy.learn.practice.backtrack;

/**
 * @author wangxiayun
 * @since 2020/7/20
 **/
public class BackTrack {

    public static void solution(int n){
        if (n == 2){
            return;
        }
        solution(n+1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        solution(0);
    }
}
