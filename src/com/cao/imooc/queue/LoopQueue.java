package com.cao.imooc.queue;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2018年08月02日 09:28
 */
public class LoopQueue<E> implements Queue<E> {
    E[] data;
    int tail;
    int front;
    int size;

    public LoopQueue(){
        this(10);
    }

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
        tail = 0;
        front = 0;
    }

    @Override
    public void enqueue(E e) {
        if(size == data.length){
            resize(data.length * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++ ;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i< size ; i++){
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        tail = size;
        front = 0;
    }

    @Override
    public E dequeue() {
        if(size == 0 ){
            throw new IllegalArgumentException("dequeue failed, queue is empty");
        }
        if(size == data.length/4 && size > 4){
            resize(data.length / 2);
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size -- ;
        return e;
    }

    @Override
    public E getFront() {
        if(size == 0 ){
            throw new IllegalArgumentException("dequeue failed, queue is empty");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("LoopQueue: size = %d, capacity = %d", size, data.length));
        builder.append("    front[");
        for(int i = front; i != tail; i = (i + 1) % data.length){
            builder.append(data[i]);
            if(i != tail - 1){
                builder.append(", ");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        Queue queue = new LoopQueue<>();
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
