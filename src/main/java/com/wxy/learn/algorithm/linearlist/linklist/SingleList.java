package com.wxy.learn.algorithm.linearlist.linklist;

import java.util.Objects;

public class SingleList implements ISingleList {
    private Node head = null;

    public static class Node {
        public int data;
        public Node next;

        public Node() {
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        public Node getNode() {
            return next;
        }

        public void setNode(Node node) {
            this.next = node;
        }

        public int getData() {
            return data;
        }
    }

    @Override
    public Node findByValue(int value) {
        Node p = head;

        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    @Override
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;

    }

    //无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    @Override
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    //顺序插入
    //链表尾部插入
    @Override
    public void insertTail(int value) {

        Node newNode = new Node(value, null);
        //空链表，可以插入新节点作为head，也可以不操作
        if (head == null) {
            head = newNode;

        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    @Override
    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }

        newNode.next = p.next;
        p.next = newNode;
    }


    @Override
    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;

    }

    @Override
    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }

    @Override
    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) {
            return;
        }

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }

    }

    @Override
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    //判断true or false
    @Override
    public boolean TFResult(Node left, Node right) {
        Node l = left;
        Node r = right;

        boolean flag = true;
        System.out.println("left_:" + l.data);
        System.out.println("right_:" + r.data);
        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
                continue;
            } else {
                flag = false;
                break;
            }

        }

        System.out.println("什么结果");
        return flag;
       /* if (l==null && r==null){
           System.out.println("什么结果");
           return true;
        }else{
           return false;
        }*/
    }

    //　判断是否为回文

    @Override
    public boolean palindrome() {
        if (head == null) {
            return false;
        } else {
            System.out.println("开始执行找到中间节点");
            Node p = head;
            Node q = head;
            if (p.next == null) {
                System.out.println("只有一个元素");
                return true;
            }
            while (q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;

            }

            System.out.println("中间节点" + p.data);
            System.out.println("开始执行奇数节点的回文判断");
            Node leftLink = null;
            Node rightLink = null;
            if (q.next == null) {
                //　p 一定为整个链表的中点，且节点数目为奇数
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
                System.out.println("左边第一个节点" + leftLink.data);
                System.out.println("右边第一个节点" + rightLink.data);

            } else {
                //p q　均为中点
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }
            return TFResult(leftLink, rightLink);

        }
    }

    //带结点的链表翻转
    @Override
    public Node inverseLinkList_head(Node p) {
        //　Head　为新建的一个头结点
        Node Head = new Node(9999, null);
        // p　为原来整个链表的头结点,现在Head指向　整个链表
        Head.next = p;
        /*
        带头结点的链表翻转等价于
        从第二个元素开始重新头插法建立链表
        */
        Node Cur = p.next;
        p.next = null;
        Node next = null;

        while (Cur != null) {
            next = Cur.next;
            Cur.next = Head.next;
            Head.next = Cur;
            System.out.println("first " + Head.data);

            Cur = next;
        }

        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return Head;

    }

    //无头结点的链表翻转
    @Override
    public Node inverseLinkList(Node node) {
        Node curr = node, pre = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    //检测环
    @Override
    public  boolean checkCircle(Node list) {
        if (list == null) {
            return false;
        }
        Node fast = list.next;
        Node slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }



    @Override
    public void printNode(Node node) {
        while (node!=null){
            System.out.print(node.data);
            if (Objects.nonNull(node.next)){
                System.out.print(",");
            }
            node = node.next;

        }
        System.out.println();
    }



    public  Node createNode(int value) {
        return new Node(value, null);
    }


    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.insertTail(1);
        singleList.insertTail(3);
        singleList.insertTail(5);
        singleList.insertTail(6);
        singleList.insertTail(7);

        SingleList singleList2 = new SingleList();
        singleList2.insertTail(2);
        singleList2.insertTail(4);
        singleList2.insertTail(6);
        Node node = singleList.inverseLinkList_head(singleList.findByIndex(0));
     //   Node node = singleList.mergeTwoLists(singleList.findByIndex(0),singleList2.findByIndex(0));


        singleList.printNode(node);
    }

}
