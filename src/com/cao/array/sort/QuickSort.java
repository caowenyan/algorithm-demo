package com.cao.array.sort;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description 快速排序 时间复杂度O(nlgn) 非稳定排序
 * @date 2018年07月17日 16:22
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start >= end)
            return;
        int mid = partition(arr, start, end);
        quickSort(arr, start, mid-1);
        quickSort(arr, mid+1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int data = arr[start];
        int index = start;
        while(start < end){
            while(arr[end] >= data && end != start){
                end--;
            }
            while(arr[start] <= data && end != start){//包含了第一元素，必须包含等号
                start++;
            }
            if(start < end){
                swap(arr, start, end);
            }
        }
        swap(arr, index, start);
        return start;
    }
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr={6,3,8,2,9,1,5,7,4,0,12,10};
        quickSort(arr);
        for(int data: arr)
            System.out.println(data);
    }
}
