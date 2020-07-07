package com.wxy.learn.practice.tree.leetcode;

import java.util.Stack;

/**
 * 验证查找二叉树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 *
 * @author wangxiayun
 * @since 2020/7/3
 **/
public class CheckBinaryTree {


    /**
     * 解法一: 递归(T(On) SO(n))
     *
     * @param
     * @return
     */
    public static boolean checkBinaryTree(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.data;
        // 节点的左子树只包含小于当前节点的数
        if (lower != null && val <= lower) {
            return false;
        }
        // 节点的右子树只包含大于当前节点的数
        if (upper != null && val >= upper) {
            return false;
        }

        if (!(checkBinaryTree(node.left, lower, val))) {
            return false;
        }

        if (!checkBinaryTree(node.right, val, upper)) {
            return false;
        }

        return true;
    }

    /**
     * leetcode解法二: 中序遍历 S(On) T(On)
     * @param root
     * @return
     */
    public static boolean checkBinaryTree2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.data <= inorder) {
                return false;
            }

            inorder = root.data;
            root = root.right;
        }

        return true;
    }

    public static boolean validate(TreeNode root) {
        return checkBinaryTree(root, null, null);
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
