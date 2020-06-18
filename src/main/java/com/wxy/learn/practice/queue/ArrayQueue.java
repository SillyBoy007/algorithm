package com.wxy.learn.practice.queue;
/**
 * 队列的基本操作
 * add    增加一个元索如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * 　　remove   移除并返回队列头部的元素,如果队列为空，则抛出一个NoSuchElementException异常
 * 　　element  返回队列头部的元素如果队列为空，则抛出一个NoSuchElementException异常
 * 　　offer   添加一个元素并返回true,如果队列已满，则返回false
 * 　　poll    移除并返问队列头部的元素,如果队列为空，则返回null
 * 　　peek    返回队列头部的元素,如果队列为空，则返回null
 * 　　put    添加一个元素,如果队列满，则阻塞
 * 　　take    移除并返回队列头部的元素,如果队列为空，则阻塞
 */

import com.wxy.learn.datastructure.linearlist.queue.CircularQueue;
import com.wxy.learn.datastructure.linearlist.queue.DynamicArrayQueue;

/**
 * 基于数组实现队列
 * 缺陷:随着不停地进行入队、出队操作，head 和 tail 都会持续往后移动。当 tail 移动到最右边，即使数组中还有空闲空间，也无法继续往队列中添加数据了。
 * <p>
 * 解决:
 * 1.数据搬移 ,入队会使操作复杂度提升
 *
 * @see DynamicArrayQueue
 * <p>
 * 2.循环队列
 * @see CircularQueue
 */
public class ArrayQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;

    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        //队列满了
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        tail++;
        return true;
    }


    public String dequeue() {
        //队列为空
        if (tail == head){
            return null;
        }

        String res = items[head];
        head ++;
        return res;
    }

    public void printAll(){
        for (int i = head; i < tail; i++) {
            System.out.print(items[i]+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");

        System.out.println(queue.dequeue());


        queue.printAll();

    }
}
