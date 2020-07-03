package com.wxy.learn.datastructure.tree.leetcode;

import com.sun.org.apache.regexp.internal.RE;
import javafx.util.Pair;

import java.util.*;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author wangxiayun
 * @since 2020/7/3
 **/
public class TreeDeep {

    /**
     * leetCode解法一: 深度优先递归
     * <p>
     * 时间复杂度O(n)
     * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
     */

    public int treeDeepRec(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int left = treeDeepRec(treeNode.left);

        int right = treeDeepRec(treeNode.right);

        return Math.max(left, right) + 1;
    }

    /**
     * leetCode解法二: BFS层次遍历思想
     * BFS迭代实现二叉树最大深度
     * 时间复杂度O(n)
     * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
     *
     * @return
     */
    public int treeDeepBFS(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        int maxDeep = 0;
        while (!queue.isEmpty()) {
            maxDeep++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pollFirst();
                if (Objects.nonNull(node.left)) {
                    queue.add(node.left);
                }

                if (Objects.nonNull(node.right)) {
                    queue.add(node.right);
                }
            }
        }

        return maxDeep;
    }

    /**
     * leetCode解法三: DFS前序遍历思想
     * DFS迭代实现二叉树最大深度
     * 时间复杂度O(n)
     * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
     *
     * @return
     */
    public int treedDeepDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<Record> stack = new Stack<>();
        stack.add(new Record(root, 1));

        //记录访问过的节点
        HashSet<TreeNode> set = new HashSet<>();
        set.add(root);

        int depth = 0;
        Record curr;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            depth = Math.max(depth, curr.level);
            if (curr.node.left != null && !set.contains(curr.node.left)) {
                stack.push(curr);
                stack.push(new Record(curr.node.left, curr.level + 1));
                set.add(curr.node.left);
                continue;
            }

            if (curr.node.right != null && !set.contains(curr.node.right)) {
                stack.push(curr);
                stack.push(new Record(curr.node.right, curr.level + 1));
                set.add(curr.node.right);
                continue;
            }
        }

        return depth;

    }


    public static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }


    public static class Record {
        private TreeNode node;
        private int level;

        Record(TreeNode treeNode, int level) {
            this.node = treeNode;
            this.level = level;
        }
    }
}
