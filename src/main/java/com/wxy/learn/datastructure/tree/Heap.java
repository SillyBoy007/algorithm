package com.wxy.learn.datastructure.tree;

/**
 * 堆
 *
 * @author wxy
 * @since 2020-07-08
 */
public class Heap {
    /**
     * 存放数据容器
     */
    private int[] a;
    /**
     * 堆中最大可存放元素个数
     */
    private int n;

    /**
     * 堆中实际存放的元素个数
     */
    private int count;

    public Heap(int capacity) {
        this.a = new int[capacity];
        this.n = capacity + 1;
        this.count = 0;
    }



    /**
     * [1,2,3,4,5,6]
     *
     *          1
     *
     *    2           3
     *
     * 4    5     6      0
     *
     * 堆化，父节点的位置 p = 子节点的数据位置 i / 2
     *
     * 复杂度 O（log n）
     */


    public void insert(int data) {
        //堆已满
        if (count >= n) {
            return;
        }

        ++count;
        a[count] = data;

        int i = count;

        while (i / 2 > 0 && a[i] > a[i / 2]) { //自上往下堆化
            swap(a, i, i / 2);
            i = i / 2;
        }

    }


    public void removeMax(){
        //堆为空
        if (count == 0){
            return;
        }
        a[1] = a[count];
        -- count;
        heapify(a,count, 1);
    }


    private void heapify(int[] a ,int n,int i){
        while (true){
            int maxPos = i;
            if (i*2<=n && a[i] < a[i*2]){
                maxPos = i * 2;
            }

            if (i*2+1 <= n && a[i] < a[i*2+1]){
                maxPos = i * 2 + 1;
            }

            if (maxPos == i){
                break;
            }

            swap(a,maxPos,i);
            i = maxPos;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }




}
