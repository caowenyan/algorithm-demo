package com.cao.list.linked;

import java.util.Arrays;
import java.util.List;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2018年07月07日 15:13
 */
public class LinkedListCreator<E> {
    public Node createLinkedList(List<E> data){
        return createLinkedList(data , 0);
    }

    private Node createLinkedList(List<E> data, int i) {
        if(data == null || data.size() == 0)
            return null;
        if(data.size() == i+1){
            return new Node(data.get(i));
        }
        Node next = createLinkedList(data, i+1);
        return new Node(data.get(i), next);
    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        System.out.println(creator.createLinkedList(null));
        System.out.println(creator.createLinkedList(Arrays.asList(1)));
        System.out.println(creator.createLinkedList(Arrays.asList(1,2,3,4,5)));
    }
}
