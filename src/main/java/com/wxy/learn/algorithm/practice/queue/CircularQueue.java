package com.wxy.learn.algorithm.practice.queue;

/**
 * 循环队列
 *
 * @author wangxiayun
 * @since 2020/4/14
 **/
public class CircularQueue {
    /**
     * 数组容器
     */
    private String[] items;
    /**
     * 数组大小
     */
    private int n = 0;

    /**
     * head表示队头下标
     */
    private int head = 0;

    /**
     * 对尾下标
     */
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     *
     * @param item
     * @return
     */
    public boolean enQueue(String item) {
        //队列满了
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }


    private String deQueue() {
        /**
         * 队列为空
         */
        if (head == tail) {
            return null;
        }

        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }
}
