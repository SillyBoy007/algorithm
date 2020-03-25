package com.wxy.learn.algorithm.practice.array;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 实现动态扩容数组
 *
 * @author wangxiayun
 * @since 2020/3/24
 **/
@Slf4j
public class DynamicArray extends BaseArray{


    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
    }

    public void add(int index, int data) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException();
        }
        /**
         * 如果数组实际容量达到上限，则进行扩容
         */
        if (Objects.equals(this.size, this.capacity)) {
            this.resize(this.capacity * 2);
        }

        for (int i = size; i > index; i--) {
            this.arr[i] = this.arr[i - 1];
        }
        this.arr[index] = data;
        this.size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException();
        }
        for (int i = index; i < size; i++) {
            this.arr[i] = this.arr[i+1];
        }
        this.size--;
        /**
         * 如果是容积是实际数组的四倍，则进行缩容
         */
        if (this.size <= this.capacity / 4) {
            this.cutSize(this.capacity / 2);
        }

    }
    public int getSize() {
        return size;
    }

    public int get(int index) {
        return this.arr[index];
    }

    public void update(int index, int data) {
        this.arr[index] = data;
    }


    public void resize(int resize) {
        int[] newArr = new int[resize];
        for (int i = 0; i < size; i++) {
            newArr[i] = this.arr[i];
        }
        this.arr = newArr;
        this.capacity = resize;
    }

    public void cutSize(int cutSize) {
        int[] newArr = new int[cutSize];
        for (int i = 0; i < size; i++) {
            newArr[i] = this.arr[i];
        }
        this.arr = newArr;
        this.capacity = cutSize;
    }



    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(2);
        arr.add(0, 1);
        arr.add(1, 2);
        arr.add(2, 3);
        arr.add(3, 4);
        arr.add(2, 7);
        arr.delete(1);
        arr.delete(0);

        arr.print();
    }

}
