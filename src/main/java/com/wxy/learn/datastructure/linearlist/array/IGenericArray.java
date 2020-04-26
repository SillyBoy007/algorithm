package com.wxy.learn.datastructure.linearlist.array;

public interface IGenericArray<T> {
    /**
     * 获取数组容量
     *
     * @return
     */
    int getCapacity();

    /**
     * 获取当前元素个数
     *
     * @return
     */
    int count();

    /**
     * 判断数组是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 修改 index 位置的元素
     * @param index
     * @param e
     */
    void set(int index, T e);

    /**
     * 获取对应 index 位置的元素
     * @param index
     * @return
     */
    T get(int index);

    /**
     * 查看数组是否包含元素e
     * @param e
     * @return
     */
    boolean contains(T e);

    /**
     * 获取对应元素的下标, 未找到，返回 -1
     * @param e
     * @return
     */
    int find(T e);

    /**
     * 在 index 位置，插入元素e, 时间复杂度 O(m+n)
     * @param index
     * @param e
     */
    void add(int index, T e);

    /**
     * 向数组头插入元素
     * @param e
     */
    void addFirst(T e);

    /**
     * 向数组尾插入元素
     * @param e
     */
    void addLast(T e);

    /**
     * 删除 index 位置的元素，并返回
     * @param index
     * @return
     */
    T remove(int index);

    /**
     * 删除第一个元素
     * @return
     */
    T removeFirst();

    /**
     * 删除末尾元素
     * @return
     */
    T removeLast();

    /**
     * 从数组中删除指定元素
     * @param e
     */
    void removeElement(T e);
}
