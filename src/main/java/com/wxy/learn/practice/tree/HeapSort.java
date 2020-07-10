package com.wxy.learn.practice.tree;

/**
 * @author wxy
 * @since 2020-07-09
 */
public class HeapSort {

    public void heapSort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        /**
         * 1.建堆
         */
        buildHeap(a);

        int k = a.length - 1;

        while (k > 0) {
            /**
             * 堆顶最大元素与最后一个数交换
             */
            swap(a, 0, k);

            //剩下元素重新堆化
            heaping(a, --k, 0);
        }

    }

    /**
     * 建堆
     */
    public void buildHeap(int[] a) {
        for (int i = (a.length - 1) / 2; i > 0; i--) {
            heaping(a, a.length - 1, i);
        }
    }


    public void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    /**
     * 堆化
     *
     * @param a
     * @param n 要堆化的长度
     * @param i 从哪里开始堆化
     */
    public void heaping(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 + 1 <= n && a[i * 2 + 1] > a[i]) {
                maxPos = i * 2 + 1;
            }


            if (i * 2 + 2 <= n && a[i * 2 + 2] > a[i]) {
                maxPos = i * 2 + 2;
            }

            if (maxPos == i) {
                break;
            }

            i = maxPos;
        }
    }
}
