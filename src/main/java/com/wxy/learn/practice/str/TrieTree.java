package com.wxy.learn.practice.str;


import java.util.Objects;

/**
 * @author wxy
 * @since 2020-06-18
 */
public class TrieTree {
    private static TrieNode root = new TrieNode('/');


    public static void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (Objects.isNull(p.children[index])) {
                TrieNode trieNode = new TrieNode(text[index]);
                p.children[index] = trieNode;
            }

            p = p.children[index];
        }
        p.isLastChar = true;
    }


    public boolean find(char[] text) {
        TrieNode p = root;

        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';

            if (p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }

        if (!p.isLastChar){
            return false;
        }

        return true;
    }
}
