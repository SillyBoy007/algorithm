package com.wxy.learn.algorithm.str;

/**
 * @author wangxiayun
 * @since 2020/3/23
 **/
public class TrieNode {
    char data;
    TrieNode[] children = new TrieNode[26];
    /**
     * 是否是最后一个字符串
     */
    boolean isEndingChar;

   public TrieNode(char data){
       this.data = data;
   }
}
