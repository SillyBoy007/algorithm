package com.wxy.learn.datastructure.linearlist.practice;

public class PrimaryLink<T> {
    private Node<T> head;


    public void add(T data) {
        Node<T> newNode = new Node<>(data, null);
        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    /**
     * not impl
     * @param data
     */
    public void delete(T data) {
        if (head == null) {
            return;
        }

        Node curr = head;
        Node prev = null;
        while (curr != null && curr.data != data) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            return;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }

    }


    public Node<T> get(T data) {
        Node<T> p = head;
        while (p != null && p.data != data) {
            p = p.next;
        }
        return p;
    }

    public class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }


    private void printAll() {
        Node<T> p = head;
        while (p != null) {
            System.out.print(p.data+"   ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrimaryLink<Integer> link = new PrimaryLink<>();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        link.printAll();

        link.delete(4);
        link.printAll();

    }
}
