package com.wxy.learn.datastructure.tree.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 翻转二叉树
 * @author wangxiayun
 * @since 2020/7/2
 **/
public class ReserveTree {
    private  Node root;


    /**
     * leetCode解法一: 递归遍历(T(On) S(On))
     * @param root
     * @return
     */
    public static Node invertTree(Node root){
        if (root == null){
            return null;
        }

        Node left = invertTree(root.left);
        Node right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }


    /**
     * leetCode解法二: 队列遍历(T(On) S(On))
     * @param root
     * @return
     */
    public Node invertTree2(Node root){
        if (root == null){
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node current = queue.poll();
            Node tmp = current.left;
            current.left = current.right;
            current.right = tmp;

            if (current.left != null){
                queue.add(current.left);
            }

            if (current.right != null){
                queue.add(current.right);
            }
        }
        return root;

    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data = data;
        }
    }

}
