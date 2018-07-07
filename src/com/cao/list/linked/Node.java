package com.cao.list.linked;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2018年07月07日 15:14
 */
public class Node<E> {
    private E value;
    private Node next;
    public Node(E value){
        this.value = value;
    }
    public Node(E value, Node next){
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node currentHead = this;
        while(currentHead != null){
            builder.append(currentHead.value+"  ");
            currentHead = currentHead.next;
        }
        return builder.toString();
    }
}
