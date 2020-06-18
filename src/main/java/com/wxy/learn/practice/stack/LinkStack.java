package com.wxy.learn.practice.stack;

/**
 * 基于链表实现的栈
 *
 * @author wangxiayun
 * @since 2020/4/3
 **/
public class LinkStack {
    Node top = null;

    public void push(int data) {
        Node newNode = new Node(data, null);

        if (top == null) {
            top = newNode;
            return;
        }
        top.next = newNode;
        top = newNode;

    }

    public int pop(){
        if (top == null){
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return this.data;
        }

        public Node getNode() {
            return this.next;
        }
    }
}
