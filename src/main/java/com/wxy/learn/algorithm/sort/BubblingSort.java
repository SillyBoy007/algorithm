package com.wxy.learn.algorithm.sort;

import java.util.Arrays;

/**
 * @author wxy
 * 冒泡排序，冒泡排序优化
 *(On2),稳定,原地排序(O1)
 */
public class BubblingSort {
    public static void bubblingSort(int[] arr, int size) {
        if (size <= 1) {
            return;
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = 0; j < size - 1; j++) {
                System.out.println("第"+ ++count+"次循环:"+ Arrays.toString(arr));

                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                }
            }
            if (!flag) {
                break;  // 没有数据交换，提前退出
            }
        }
    }

    /**
     * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     */

    public static void bubbleSort2(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        // 最后一次交换的位置
        int lastExchange = 0;
        int count = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;
        for (int i = 0; i < n; i++) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                System.out.println("第"+ ++count+"次循环:"+ Arrays.toString(a));

                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                    // 更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag) {
                break;    // 没有数据交换，提前退出
            }
        }
    }


    /**
     * 向下冒泡。可能比冒泡更易懂？
     *
     * 算法概要：
     * 从0开始，用这个元素去跟后面的所有元素比较，如果发现这个元素大于后面的某个元素，则交换。
     * 3 2 6 4 5 1
     * 第一趟是从 index=0 也就是 3， 开始跟index=1及其后面的数字比较
     *  3 大于 2，交换，变为 2 3 6 4 5 1，此时index=0的位置变为了2
     *    接下来将用2跟index=2比较
     *  2 不大于 6 不交换
     *  2 不大于 4 不交换
     *  2 不大于 5 不交换
     *  2 大于 1，交换，变为 1 3 6 4 5 2，第一趟排序完成。
     *
     * 第二趟是从 index=1 也就是 3，开始跟index=2及其后面的数字比较
     *  3 不大于 6 不交换
     *  3 不大于 4 不交换
     *  3 不大于 5 不交换
     *  3 大于 2，交换，变为 1 2 6 4 5 3，第二趟排序完成。
     *
     * 第三趟是从 index=2 也就是 6，开始跟index=3及其后面的数字比较
     *  6 大于 4，交换，变为 1 2 4 6 5 3, 此时 index = 2 的位置变为了4
     *     接下来将用4跟index=4比较
     *  4 不大于 5 不交换
     *  4 大于 3，交换，变为 1 2 3 6 5 4，第三趟排序完成。
     *
     * 第四趟是从 index=3 也就是 6，开始跟index=4及其后面的数字比较
     *  6 大于 5，交换，变为 1 2 3 5 6 4, 此时 index = 3 的位置变为了5
     *     接下来将用5跟index=5比较
     *  5 大于 4，交换，变为 1 2 3 4 6 5, 第四趟排序完成。
     *
     * 第五趟是从 index=4 也就是 6，开始跟index=5及其后面的数字比较
     *  6 大于 5，交换，变为 1 2 3 4 5 6, 此时 index = 4 的位置变为了5
     *     接下来将用5跟index=6比较
     *  index = 6 已经不满足 index < length 的条件，整个排序完成。
     */
    private static void bubbleDownSort(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return;
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                System.out.println("第"+ ++count+"次循环:"+ Arrays.toString(arr));

                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }



    public static void main(String[] args) {
        int [] a = {4,5,6,3,2,1};
        bubbleDownSort(a);
        System.out.println(Arrays.toString(a));
    }
}
