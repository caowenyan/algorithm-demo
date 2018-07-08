package com.cao.list.linked;

import java.util.Arrays;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description 删除链表中的某个值
 * @date 2018年07月08日 13:36
 */
public class LinkedListDeletor<E> {
    /**
     * 递归删除链表中的某个值value
     * @param root
     * @param value 被删除的结果值
     * @return
     */
    public Node deleteIfEquals(Node root, E value){
        if(root == null)
            return null;
        if(root.getValue().equals(value))
            return deleteIfEquals(root.getNext(),value);
        root.setNext(deleteIfEquals(root.getNext(),value));
        return root;
    }
    /**
     * 非递归删除链表中的某个值value
     * @param root
     * @param value 被删除的结果值
     * @return
     */
    public Node deleteIfEqualsNoRecursion(Node root, E value){
        while(root!=null && root.getValue().equals(value)){
            root = root.getNext();
        }
        if(root==null){
            return null;
        }
        Node current = root;
        //判断current不等于null是因为可能最后一个是要删除的
        while(current!=null && current.getNext() != null){
            if(current.getNext().getValue().equals(value)){
                Node next = current.getNext().getNext();
                while (next !=null && next.getValue().equals(value)){
                    next = next.getNext();
                }
                current.setNext(next);
            }
            current = current.getNext();
        }
        return root;
    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        LinkedListDeletor deletor = new LinkedListDeletor();
        System.out.println(deletor.deleteIfEqualsNoRecursion(creator.createLinkedList(null),1));
        System.out.println(deletor.deleteIfEqualsNoRecursion(creator.createLinkedList(Arrays.asList()),1));
        System.out.println(deletor.deleteIfEqualsNoRecursion(creator.createLinkedList(Arrays.asList(2,3,4)),1));
        System.out.println(deletor.deleteIfEqualsNoRecursion(creator.createLinkedList(Arrays.asList(1,2,3,4)),1));
        System.out.println(deletor.deleteIfEqualsNoRecursion(creator.createLinkedList(Arrays.asList(1,2,3,1,2,3)),1));
        System.out.println(deletor.deleteIfEqualsNoRecursion(creator.createLinkedList(Arrays.asList(2,3,1,2,3)),1));
        System.out.println(deletor.deleteIfEqualsNoRecursion(creator.createLinkedList(Arrays.asList(1,1,2,3,1,2,3,1,1)),1));
    }
}
