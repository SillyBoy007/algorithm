package com.wxy.learn.algorithm.str;

/**
 * 如何实现搜索引擎的搜索关键词提示功能
 * 字符串查找
 * Trie树
 *
 * @author wangxiayun
 * @since 2020/3/23
 **/
public class TrieTree {
    private static TrieNode root = new TrieNode('/');

    /**
     * 往 Trie 树中插入一个字符串
     *
     * @param text
     */
    public static void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }


    public static boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; ++i) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                // 不存在
                return false;
            }
            p = p.children[index];
        }
        //不能完全匹配
        if (!p.isEndingChar) {
            return false;
        }
        return true;

    }


    public static void main(String[] args) {
        char[] a = {'w', 'a', 'n', 'g'};

        char[] b = {'x', 'i'};
        TrieTree.insert(a);
        TrieTree.insert(b);

        char[] s = {'w', 'a', 'n', 'g'};
        char[] t = {'x', 'i'};

        System.out.println(TrieTree.find(s));
        System.out.println(TrieTree.find(t));

    }
}
