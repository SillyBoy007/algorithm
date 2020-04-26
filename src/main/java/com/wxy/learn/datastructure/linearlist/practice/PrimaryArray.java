package com.wxy.learn.datastructure.linearlist.practice;


public class PrimaryArray<T> {
    /**
     * 数组元素个数
     */
    private int size;

    /**
     * 数组容器
     */
    private T[] data;


    public PrimaryArray(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public void addLast(T value) {
        this.add(size, value);
    }

    public void add(int index, T value) {
        if (index<0 || index > size){
            throw new IllegalArgumentException("参数错误");
        }
        if (data.length == size) {
            resize(data.length * 2);
        }

        for (int i = index; i < size; i++) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    public T delete(int index) {
        this.check(index);

        System.out.println("size:"+size);

        T ret = data[index];

        for (int i = index + 1; i < size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
        data[size] = null;

        if (data.length / 4 == size) {
            resize(data.length / 2);
        }
        return ret;
    }

    public void update(int index, T value) {
        this.check(index);
        data[index] = value;
    }

    public T get(int index) {
        return data[index];
    }


    private void resize(int mult) {
        T[] newArr = (T[]) new Object[mult];
        for (int i = 0; i < size; i++) {
            newArr[i] = data[i];
        }
        data = newArr;
    }

    private void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i != size - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println(String.format("数组容量为：%s", data.length));
    }

    private void check(int index){
        if (index<0 || index >= size){
            throw new IllegalArgumentException("参数错误");
        }
    }
    public static void main(String[] args) {
        PrimaryArray<Integer> primaryArray = new PrimaryArray<>(2);
        primaryArray.addLast(1);
        primaryArray.addLast(2);
        primaryArray.addLast(3);
        primaryArray.addLast(4);
        primaryArray.addLast(1);
        primaryArray.addLast(2);
        primaryArray.addLast(3);
        primaryArray.addLast(4);
        primaryArray.printAll();

        primaryArray.delete(1);
        primaryArray.delete(2);

        primaryArray.delete(3);
        primaryArray.delete(4);


        primaryArray.printAll();

    }

}
