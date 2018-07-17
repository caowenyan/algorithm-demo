package com.cao.array.sort;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description 选择排序 时间复杂度O(n^2)
 * @date 2018年07月17日 15:47
 */
public class SelectSort {
    public static void selectSort(int[] arr) {
        for(int i = 0; i< arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
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
        selectSort(arr);
        for(int data: arr)
            System.out.println(data);
    }
}
