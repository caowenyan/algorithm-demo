package com.cao.list.linked;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2018年07月07日 15:33
 */
public class LinkedListReverser<E> {
    /**
     * 链表反转
     * @param root
     * @return
     */
    public Node reverseLinedList(Node root){
        if(root == null)
            return null;
        if(root.getNext() == null)
            return root;
        Node head = reverseLinedList(root.getNext());
        //当前节点root的next还指向next的引用，也就是返回的head的最后一位
        root.getNext().setNext(root);
        root.setNext(null);
        return head;
    }

    /**
     * 链表反转，非递归
     * @param root
     * @return
     */
    public Node reverseLinedListNoRecursion(Node root){
        if(root == null)
            return null;

        Node newHead = null;
        Node currentHead = root;
        while(currentHead!=null){
            Node next = currentHead.getNext();
            currentHead.setNext(newHead);
            newHead = currentHead;
            currentHead = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        LinkedListReverser reverser = new LinkedListReverser();
//        System.out.println(reverser.reverseLinedList(creator.createLinkedList(null)));
//        System.out.println(reverser.reverseLinedList(creator.createLinkedList(Arrays.asList(1))));
//        System.out.println(reverser.reverseLinedList(creator.createLinkedList(Arrays.asList(1,2,3,4,5))));

        System.out.println(reverser.reverseLinedListNoRecursion(creator.createLinkedList(null)));
        System.out.println(reverser.reverseLinedListNoRecursion(creator.createLinkedList(Arrays.asList(1))));
        System.out.println(reverser.reverseLinedListNoRecursion(creator.createLinkedList(Arrays.asList(1,2,3,4,5))));
    }
}
