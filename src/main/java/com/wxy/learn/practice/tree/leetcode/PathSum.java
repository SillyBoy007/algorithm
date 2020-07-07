package com.wxy.learn.practice.tree.leetcode;

/**
 *
 * 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * @author wxy
 * @since 2020-07-07
 */
public class PathSum {

    /**
     * 解法一:递归 T(On) S(Ologn 极端情况On)
     */

    public boolean hasPathSum(Node node,int sum){
        if (node == null){
            return false;
        }

        /**
         * 叶子节点
         */
        if (node.left == null && node.right == null){
            return node.data == sum;
        }

        return hasPathSum(node.left,sum - node.data) || hasPathSum(node.right,sum - node.data);
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
