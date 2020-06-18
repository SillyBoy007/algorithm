package com.wxy.learn.practice.hash;

import java.util.HashMap;

/**
 * LRU缓存淘汰算法
 * 最近最少使用淘汰算法
 *
 * @author wxy
 * @since 2020-06-16
 */
public class LRUCacheHash<K, V> {


    /**
     * 默认链表容量
     */
    private final static int DEFAULT_CAPACITY = 10;


    /**
     * 前驱节点
     */
    private DNode<K, V> headNode;

    /**
     * 后驱节点
     */
    private DNode<K, V> tailNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    /**
     * 散列表存储key
     */
    private HashMap<K, DNode<K, V>> table;


    static class DNode<K, V> {

        private K key;

        private V value;

        private DNode<K, V> prev;

        private DNode<K, V> next;


        DNode() {
        }

        DNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    public LRUCacheHash(int capacity) {
        this.length = 0;
        this.capacity = capacity;
        headNode = new DNode<>();
        tailNode = new DNode<>();

        headNode.next = tailNode;
        tailNode.prev = headNode;

        table = new HashMap<>();
    }


    public LRUCacheHash() {
        this(DEFAULT_CAPACITY);
    }


    /**
     * 新增
     */
    public void add(K key,V value) {

        DNode<K,V> node = table.get(key);

        if (node == null){
            DNode<K, V> newNode = new DNode<>(key, value);
            table.put(key,newNode);
            addNodeToHead(newNode);

            if (++length >capacity){
                DNode<K, V> tail = popTail();
                table.remove(tail.key);
                length--;
            }

        }else {
            node.value = value;
            moveToHead(node);
        }



    }

    /**
     * 删除
     */

    public void remove(K key) {

        DNode<K, V> dNode = table.get(key);

        if (dNode == null) {
            return;
        }

        removeNode(dNode);
        length--;
        table.remove(dNode.key);

    }


    /**
     * 获取节点数据
     */

    public V get(K key) {
        DNode<K, V> node = table.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }


    /**
     * 添加头部节点
     *
     * @param newNode
     */
    private void addNodeToHead(DNode<K, V> newNode) {
        newNode.next = headNode.next;
        newNode.prev = headNode;

        headNode.next.prev = newNode;
        headNode.next = newNode;

    }

    private DNode<K, V> popTail() {

        DNode<K, V> dNode = tailNode.prev;
        removeNode(dNode);

        return dNode;
    }

    private void removeNode(DNode<K, V> dNode) {
        dNode.prev.next = dNode.next;
        dNode.next.prev = dNode.prev;
    }

    private void moveToHead(DNode<K, V> dNode) {

        removeNode(dNode);
        addNodeToHead(dNode);

    }

    public void printAll() {
        DNode<K, V> dNode = headNode.next;

        while (dNode.next != null) {
            System.out.println(dNode.value + " ");
            dNode = dNode.next;
        }
        System.out.println();
    }
}
