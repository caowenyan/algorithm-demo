package com.cao.imooc.queue;

import com.cao.imooc.array.Array;
import com.cao.imooc.stack.ArrayStack;
import com.cao.imooc.stack.Stack;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2018年08月01日 20:27
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> data;

    public ArrayQueue(){
        data = new Array<>();
    }

    public ArrayQueue(int capacity){
        data = new Array<>(capacity);
    }
    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    /**
     * 复杂度是O(n)
     * @return
     */
    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queue：");
        builder.append("front [");
        for(int i = 0; i < data.getSize(); i++){
            builder.append(data.get(i));
            if(i != data.getSize() - 1){
                builder.append(", ");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        Queue queue = new ArrayQueue<>();
        for(int i = 0; i < 10; i++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 0){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
