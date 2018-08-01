package com.cao.imooc.array;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2018年07月30日 14:52
 */
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /*public void addLast(E e){
        if(data.length == size){
            throw new IllegalArgumentException("AddLast is failed. Array is full.");
        }
        data[size] = e;
        size ++ ;
    }*/
    public void addLast(E e){
        add(size, e);
    }

    public void addFirst(E e){
        add(0, e);
    }

    public void add(int index, E e){
        /*if(size == data.length){
            throw new IllegalArgumentException("Add is failed. Array is full.");
        }*/
        if(index > size || index < 0){
            throw new IllegalArgumentException("Add is failed. index is invalid.");
        }
        if(size == data.length){
            resize(size * 2);
        }
        for(int i = 0; i < size - index; i++){
            data[size - index] = data[size - index - 1];
        }
        data[index] = e;
        size ++ ;
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get is failed. index is invalid.");
        }
        return data[index];
    }

    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get is failed. index is invalid.");
        }
        data[index] = e;
    }

    public boolean contains(E e){
        for(E o : data){
            if(o.equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove is failed. index is invalid.");
        }
        E ret = data[index];
        for(int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size -- ;
        if(size * 4 == data.length){
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    public void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array: size = %d, capacity = %d", size, data.length));
        builder.append("[");
        for(int i = 0; i < size; i++){
            builder.append(data[i]);
            if(i != size - 1){
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
