package com.cao.list.linked;

import java.util.Arrays;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2018年07月07日 15:33
 */
public class LinkedListReverser<E> {
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

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        LinkedListReverser reverser = new LinkedListReverser();
        System.out.println(reverser.reverseLinedList(creator.createLinkedList(null)));
        System.out.println(reverser.reverseLinedList(creator.createLinkedList(Arrays.asList(1))));
        System.out.println(reverser.reverseLinedList(creator.createLinkedList(Arrays.asList(1,2,3,4,5))));
    }
}
