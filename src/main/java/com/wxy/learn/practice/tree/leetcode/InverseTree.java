package com.wxy.learn.practice.tree.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 翻转一棵二叉树
 *
 * @author wxy
 * @since 2020-07-06
 */
public class InverseTree {

    /**
     * leetCode解法1：递归 S（On） T（On）
     * @param root
     * @return
     */
    public TreeNode inverseTree(TreeNode root) {
        if (root == null) {
            return null;
        }


        TreeNode left = inverseTree(root.left);

        TreeNode right = inverseTree(root.right);


        root.left = right;

        root.right = left;

        return root;
    }

    /**
     * 层序遍历（广度优先遍历） S(On) T(On)
     * @param root
     * @return
     */
    public TreeNode inverseTree2(TreeNode root){
        if (root == null){
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();

            TreeNode tmp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tmp;


            while (treeNode.left != null){
                queue.add(treeNode);
            }

            while (treeNode.right != null){
                queue.add(treeNode);
            }

        }
        return root;

    }


    public static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
