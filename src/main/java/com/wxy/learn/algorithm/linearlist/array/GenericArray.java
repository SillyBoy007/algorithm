package com.wxy.learn.algorithm.linearlist.array;

import java.util.Objects;

public class GenericArray<T> implements  IGenericArray{
    private Object[] data;
    private int size;

    // 根据传入容量，构造Array
    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // 无参构造方法，默认数组容量为10
    public GenericArray() {
        this(10);
    }

    // 获取数组容量
    @Override
    public int getCapacity() {
        return data.length;
    }

    // 获取当前元素个数
    @Override
    public int count() {
        return size;
    }

    // 判断数组是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 修改 index 位置的元素
    @Override
    public void set(int index, Object e) {
        checkIndex(index);
        data[index] = e;
    }

    // 获取对应 index 位置的元素
    @Override
    public Object get(int index) {
        checkIndex(index);
        return data[index];
    }

    // 查看数组是否包含元素e
    @Override
    public boolean contains(Object e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 获取对应元素的下标, 未找到，返回 -1
    @Override
    public int find(Object e) {
        for ( int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


    // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
    @Override
    public void add(int index, Object e) {
        checkIndexForAdd(index);
        // 如果当前元素个数等于数组容量，则将数组扩容为原来的2倍
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 向数组头插入元素
    @Override
    public void addFirst(Object e) {
        add(0, e);
    }

    // 向数组尾插入元素
    @Override
    public void addLast(Object e) {
        add(size, e);
    }

    // 删除 index 位置的元素，并返回
    @Override
    public Object remove(int index) {
        checkIndex(index);

        Object ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;

        // 缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    // 删除第一个元素
    @Override
    public Object removeFirst() {
        return remove(0);
    }

    // 删除末尾元素
    @Override
    public Object removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除指定元素
    @Override
    public void removeElement(Object e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }


    // 扩容方法，时间复杂度 O(n)
    private void resize(int capacity) {
        Object[] newData = (Object[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }

    private void checkIndexForAdd(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index <= size.");
        }
    }
}
