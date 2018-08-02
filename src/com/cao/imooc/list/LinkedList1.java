package com.cao.imooc.list;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description 添加的时候需要判断是不是第一位，所以需要优化
 * @date 2018年08月02日 18:02
 */
public class LinkedList1<E> {
    private Node head;
    private int size;

    public LinkedList1() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(E e){
        head = new Node(e, head);
        size ++ ;
    }

    public void addLast(E e){
        add(size, e);
    }

    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add is failed. index is invalid.");
        }
        if(index == 0) {
            addFirst(e);
        }else {
            Node pre = head;
            for(int i = 0 ; i < index - 1 ; i++){
                pre = pre.next;
            }
            pre.next = new Node(e, pre.next);
            size ++ ;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    private static class Node<E> {
        public final E e;
        private Node next;

        public Node() {
            this(null, null);
        }
        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
