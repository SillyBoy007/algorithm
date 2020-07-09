package com.wxy.learn.practice.tree;

/**
 * 堆
 *
 * @author wxy
 * @since 2020-07-09
 */
public class Heap {
    /**
     * 堆容器
     */
    private int[] a;
    /**
     * 堆内元素个数
     */
    private int count;

    /**
     * 堆
     */
    private int n;

    public Heap(int capacity) {
        a = new int[capacity];
        n = capacity + 1;
        this.count = 0;
    }


    public void insert(int data) {
        if (count == n) {
            return;
        }

        ++count;

        a[count] = data;

        int i = count;

        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }

    }

    public void removeMax() {
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        --count;
        heaping(a, count, 1);


    }


    public void heaping(int[] a, int count, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= count && a[i * 2] > a[maxPos]) {
                maxPos = i * 2;
            }

            if (i*2 + 1 <=count && a[i*2+1]>a[maxPos]){
                maxPos = i* 2 + 1;
            }
            if (i == maxPos){
                break;
            }

            i = maxPos;
        }
    }

    public void swap(int[] a, int x, int y) {

        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;

    }
}
