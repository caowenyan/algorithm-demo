package com.cao.array.sort;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description 冒泡排序 时间复杂度O(n^2)
 * @date 2018年07月17日 15:35
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for(int i = 0; i< arr.length-1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr={6,3,8,2,9,1};
        bubbleSort(arr);
        for(int data: arr)
            System.out.println(data);
    }
}
