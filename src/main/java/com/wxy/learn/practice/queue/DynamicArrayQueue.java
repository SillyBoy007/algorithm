package com.wxy.learn.practice.queue;

/**
 * 动态数组队列
 * @author wangxiayun
 * @since 2020/5/14
 **/
public class DynamicArrayQueue {
    private String[] items;
    private int n;
    private int head;
    private int tail;


    public DynamicArrayQueue (int capacity){
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String s){
        if (tail == n){
            //head == 0 队列已满
            if (head == 0){
                return false;
            }

            for (int i = head; i <tail ; i++) {
                items[i - head] = items[i];
            }

            tail = tail - head;
            head = 0;
        }
        items[tail] = s;
        tail ++;
        return true;
    }

    public void change(String[] items,int i,int j){
        String temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    
    public String dequeue(){
        //队列为空
        if (tail == n){
            return null;
        }
        return items[head++];
    }

    public void printAll(){
        for (int i = head; i < tail; i++) {
            System.out.print(items[i]+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
