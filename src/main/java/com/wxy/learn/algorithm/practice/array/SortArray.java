package com.wxy.learn.algorithm.practice.array;


/**
 * 实现一个大小固定的有序数组，支持动态增删改操作
 *
 * @author wangxiayun
 * @since 2020/3/24
 **/
public class SortArray extends BaseArray {

    public SortArray(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
    }


    public boolean add(int value) {
        // 判断是否为空
        if (arr == null && arr.length == 0) {
            return false;
        } else {
            if (size == 0) {
                arr[size] = value;
                size++;
                return true;
            }
            if (size > 0 && arr[0] > value) {
                // 插入数组第一个位置
                for (int j = size - 1; j >= 0; j--) {
                    if(j<capacity-1){
                        arr[j + 1] = arr[j];
                    }
                }
                arr[0] = value;
                if (size<capacity){
                    size++;
                }
                return true;
            }

            // 判断是否大于最后一个元素
            if (value >= arr[size - 1]) {
                arr[size-1] = value;
                if (size<capacity){
                    size++;
                }
                return true;
            }


            int n = 0;
            // 其他数组元素相互比较挪动位置
            for (int i = 0; i < arr.length; i++) {
                if (value <= arr[i]) {
                    n = i;
                    break;
                }
            }

            if (n > 0) {
                for (int j = size; j > n; j--) {
                    if (j < arr.length) {
                        arr[j] = arr[j-1];
                    }
                }
                arr[n] = value;
                if (size<capacity){
                    size++;
                }
                return true;
            }
            return false;
        }
    }

    public void del(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        for (int i = size; i > index; i--) {
            arr[i - 1] = arr[i];
        }
        size--;
    }


    public static void main(String[] args) {
        SortArray sortArray = new SortArray(4);
        sortArray.add(3);
        sortArray.add(4);
        sortArray.add(1);
        sortArray.add(5);
        sortArray.add(2);

        sortArray.add(-1);

        sortArray.add(6);

        sortArray.print();
    }


}
