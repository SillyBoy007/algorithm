package com.wxy.learn.practice.queue.leetcode;

/**
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 * <p>
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * <p>
 *
 * @author wxy
 * @since 2020-05-28
 */
public class MyCircularDeque {

    private int[] items;

    private int front;

    private int rear;

    /**
     * 数组容量
     */
    private int capacity;

    public MyCircularDeque(int k) {
        this.capacity = k + 1;
        items = new int[capacity];
        this.front = 0;
        this.rear = 0;
    }


    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        // 注意：这个设计是非常经典的做法
        return (rear + 1) % capacity == front;
    }


    public boolean insertFront(int data) {

        if (isFull()) {
            return false;
        }

        this.front = (front - 1 + capacity) % capacity;
        items[front] = data;
        return true;

    }

    public boolean insertLast(int data) {
        if (isFull()) {
            return false;
        }
        items[rear] = data;
        rear = (rear + 1) % capacity;

        return true;
    }


    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front + 1 ) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        this.rear = (rear - 1 + capacity) % capacity;
        return true;

    }


    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return this.items[front];
    }

    public int getLast() {
        if (isEmpty()) {
            return -1;
        }
        return this.items[(rear-1 + capacity) % capacity];
    }

}
