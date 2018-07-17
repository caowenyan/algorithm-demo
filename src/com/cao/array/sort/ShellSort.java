package com.cao.array.sort;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description 希尔排序 时间复杂度：O(n^1.3)
 * @date 2018年07月17日 17:37
 */
public class ShellSort {
    public static void shellSort(int[] arr) {
        int length = arr.length / 2;
        while(length > 0){
            shellSort(arr, length);
            length /= 2;
        }
    }

    public static void shellSort(int[] arr, int d) {
        for(int i = d; i < arr.length; i++){
            int tmp = arr[i];
            int j = i - d;
            while(j >= 0 && arr[j] > tmp){
                arr[j + d] = arr[j];
                j -= d;
            }
            if(j != i-d)
                arr[j + d] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr={6,3,8,2,9,1,5,7,4,0,12,10};
        shellSort(arr);
        for(int data: arr)
            System.out.println(data);
    }
}
