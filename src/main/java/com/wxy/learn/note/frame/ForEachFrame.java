package com.wxy.learn.note.frame;

/**
 * 遍历框架
 * @author wangxiayun
 * @since 2020/4/20
 **/
public class ForEachFrame {
    /**
     * 一、数组遍历(线性遍历结构)
     */

    void foreachArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

        }
    }

    /**
     * 二、链表遍历（线性和递归遍历）
     */
    class Node {
        private int data;
        private Node next;
    }

    /**
     * 线性迭代
     * @param head
     */
    void foreachLink(Node head) {
        for (Node p = head; p != null; p = head.next) {

        }
    }

    /**
     * 递归迭代
     * @param head
     */
    void foreachLink2(Node head){
        if (head!=null) {
            foreachLink2(head.next);
        }
    }


    /**
     * 三、二叉树遍历 (递归遍历)
     */

    class TreeNode{
        int val;
        TreeNode[] children;
    }

    void foreachTree(TreeNode root){
        for (TreeNode child : root.children){
            if (child !=null){
                foreachTree(child);
            }
        }
    }
}
