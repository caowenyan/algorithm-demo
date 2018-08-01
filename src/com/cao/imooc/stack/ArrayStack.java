package com.cao.imooc.stack;

import com.cao.imooc.array.Array;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2018年08月01日 20:13
 */
public class ArrayStack<E> implements Stack<E>{
    private Array<E> data;

    public ArrayStack(){
        data = new Array<>();
    }

    public ArrayStack(int capacity){
        data = new Array<>(capacity);
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
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Stack：");
        builder.append("[");
        for(int i = 0; i < data.getSize(); i++){
            builder.append(data.get(i));
            if(i != data.getSize() - 1){
                builder.append(", ");
            }
        }
        builder.append("] top");
        return builder.toString();
    }

    public static void main(String[] args) {
        Stack stack = new ArrayStack<>();
        for(int i = 0; i < 10; i++){
            stack.push(i);
            System.out.println(stack);
            if(i % 3 == 0){
                stack.pop();
                System.out.println(stack);
            }
        }
    }
}
