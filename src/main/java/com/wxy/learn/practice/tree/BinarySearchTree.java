package com.wxy.learn.practice.tree;

import java.util.Objects;

/**
 * 二叉查找树 T(On)
 *
 * @author wangxiayun
 * @since 2020/7/2
 **/
public class BinarySearchTree {

    private Node tree;

    public static class Node {
        private Node left;
        private Node right;
        private int data;

        public Node(int data) {
            this.data = data;
        }

    }

    /**
     * 查找
     *
     * @param data
     * @return
     */
    public Node find(int data) {
        if (Objects.isNull(tree)) {
            return null;
        }

        Node p = tree;

        while (p != null) {
            if (p.data > data) {
                p = p.left;
            } else if (p.data == data) {
                return p;
            } else if (p.data > data) {
                p = p.right;
            }
        }
        return null;

    }

    /**
     * 查找最大值
     *
     * @return
     */
    public Node findMax() {
        if (Objects.isNull(tree)) {
            return null;
        }
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    /**
     * 查找最小值
     *
     * @return
     */
    public Node findMin() {
        if (Objects.isNull(tree)) {
            return null;
        }
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }

        return p;
    }

    /**
     * 新增
     *
     * @param data
     */
    public void add(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (Objects.nonNull(p)) {
            if (p.data > data) {
                if (p.left == null) {
                    p.left = new Node(data);
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new Node(data);
                }
                p = p.right;
            }
        }
    }

    /**
     * 删除
     *
     * @param data
     */
    public void del(int data) {


        Node p = tree;
        Node pp = null;

        while (p != null && p.data != data) {
            pp = p;

            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null){
            return;
        }

        if (p.left != null && p.right != null) {
            Node minP = p.right;
            Node minPp = p;
            while (minP.left !=null){
                minPp = minP;
                minP = minP.left;
            }

            p.data = minP.data;
            p = minP;
            pp = minPp;  // 下面就变成了删除 minP了
        }


        Node child;
        if (p.left !=null){
            child = p.left;
        }else if (p.right != null){
            child = p.right;
        }else {
            child = null;
        }


        if (pp == null){
            tree = child; //删除的是根节点
        }else if (pp.left == p){
            pp.left = child;
        }else if (pp.right == p){
            pp.right = child;
        }
    }
}
