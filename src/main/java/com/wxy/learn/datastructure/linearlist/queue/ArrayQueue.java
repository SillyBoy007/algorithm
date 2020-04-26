package com.wxy.learn.datastructure.linearlist.queue;


/**
 *  队列的基本操作
 *   add    增加一个元索如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 　　remove   移除并返回队列头部的元素,如果队列为空，则抛出一个NoSuchElementException异常
 　　element  返回队列头部的元素如果队列为空，则抛出一个NoSuchElementException异常
 　　offer   添加一个元素并返回true,如果队列已满，则返回false
 　　poll    移除并返问队列头部的元素,如果队列为空，则返回null
 　　peek    返回队列头部的元素,如果队列为空，则返回null
 　　put    添加一个元素,如果队列满，则阻塞
 　　take    移除并返回队列头部的元素,如果队列为空，则阻塞

 */
/**
 *
 *
 * 基于数组实现队列
 * 缺陷:随着不停地进行入队、出队操作，head 和 tail 都会持续往后移动。当 tail 移动到最右边，即使数组中还有空闲空间，也无法继续往队列中添加数据了。
 *
 * 解决:
 * 1.数据搬移 ,入队会使操作复杂度提升
 * @see DynamicArrayQueue
 *
 * 2.循环队列
 * @see CircularQueue
 */
// 用数组实现的队列
public class ArrayQueue {
  // 数组：items，数组大小：n
  private String[] items;
  private int n = 0;
  // head表示队头下标，tail表示队尾下标
  private int head = 0;
  private int tail = 0;

  // 申请一个大小为capacity的数组
  public ArrayQueue(int capacity) {
    items = new String[capacity];
    n = capacity;
  }

  // 入队
  public boolean enqueue(String item) {
    // 如果tail == n 表示队列已经满了
    if (tail == n) {
      return false;
    }
    items[tail] = item;
    ++tail;
    return true;
  }

  // 出队
  public String dequeue() {
    // 如果head == tail 表示队列为空
    if (head == tail) {
      return null;
    }
    // 为了让其他语言的同学看的更加明确，把--操作放到单独一行来写了
    String ret = items[head];
    ++head;
    return ret;
  }

  public void printAll() {
    for (int i = head; i < tail; ++i) {
      System.out.print(items[i] + " ");
    }
    System.out.println();
  }
}
