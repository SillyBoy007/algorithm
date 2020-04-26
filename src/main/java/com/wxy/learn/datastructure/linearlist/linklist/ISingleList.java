package com.wxy.learn.datastructure.linearlist.linklist;

public interface ISingleList {
    /**
     * 根据值找到节点
     * @param value
     * @return
     */
    SingleList.Node findByValue(int value);

    /**
     * 根据索引值找到节点
     * @param index
     * @return
     */
    SingleList.Node findByIndex(int index);

    /**
     * 插入值到链表头部
     * @param value
     */
    void insertToHead(int value);


    /**
     * 插入值到链表尾部
     * @param value
     */
    void insertTail(int value);

    /**
     * 插入某个值到该节点后面
     * @param p
     * @param value
     */
    void insertAfter(SingleList.Node p, int value);

    /**
     * 插入某个值到该节点前面
     * @param p
     * @param value
     */
    void insertBefore(SingleList.Node p, int value);

    /**
     * 根据节点删除
     * @param p
     */
    void deleteByNode(SingleList.Node p);

    /**
     * 根据值删除
     * @param value
     */
    void deleteByValue(int value);

    /**
     * 打印链表
     */
    void printAll();


    /**
     * 判断左右是否相等
     * @param left
     * @param right
     * @return
     */
    boolean TFResult(SingleList.Node left, SingleList.Node right);


    /**
     * 判断是否为回文
     * @return
     */
    boolean palindrome();


    /**
     * 带结点的链表翻转
     * @param p
     * @return
     */
    SingleList.Node inverseLinkList_head(SingleList.Node p);

    /**
     * 无头结点的链表翻转
     * @param node
     * @return
     */
    SingleList.Node inverseLinkList(SingleList.Node node);

    /**
     * 检测环
     * @param list
     * @return
     */
    boolean checkCircle(SingleList.Node list);



    /**
     * 根据头节点打印链表
     * @param node
     */
    void printNode(SingleList.Node node);
}
