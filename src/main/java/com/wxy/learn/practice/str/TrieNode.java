package com.wxy.learn.practice.str;

/**
 * @author wxy
 * @since 2020-06-18
 */
public class TrieNode {

     char data;

    TrieNode[] children = new TrieNode[26];

    /**
     * 是否是最后一个字符
     */
    boolean isLastChar;


    public TrieNode (char data){
        this.data = data;
    }
}
