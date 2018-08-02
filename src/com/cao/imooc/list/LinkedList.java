package com.cao.imooc.list;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description 链表的时间复杂度都是O(n)
 * @date 2018年08月02日 18:02
 */
public class LinkedList<E> {
    private Node<E> dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node<E>();
        this.size = 0;
    }

    public void addFirst(E e){
        add(0, e);
    }

    public void addLast(E e){
        add(size, e);
    }

    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add is failed. index is invalid.");
        }

        Node pre = dummyHead;
        for(int i = 0 ; i < index ; i++){
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size ++ ;
    }

    public E get(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("get is failed. index is invalid.");
        }
        Node<E> cur = dummyHead.next;
        for(int i = 0 ; i < index ; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    public void set(int index, E e){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("get is failed. index is invalid.");
        }
        Node<E> cur = dummyHead.next;
        for(int i = 0 ; i < index ; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e){
        Node node = dummyHead.next;
        while(node != null){
            if(node.e.equals(e))
                return true;
            node = node.next;
        }
        return false;
    }

    public E remove(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove is failed. index is invalid.");
        }
        Node<E> pre = dummyHead;
        for(int i = 0; i < index; i ++){
            pre = pre.next;
        }
        Node<E> ret = pre.next;
        pre.next = pre.next.next;
        ret.next = null;
        size -- ;
        return ret.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(Node node = dummyHead.next; node != null; node = node.next){
            res.append(node.e).append("->");
        }
        res.append("NULL");
        return res.toString();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    private static class Node<E> {
        private E e;
        private Node<E> next;

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

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for(int i = 0; i < 10; i ++){
            linkedList.addLast(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 22);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
    }
}
