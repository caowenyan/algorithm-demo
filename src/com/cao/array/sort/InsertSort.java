package com.cao.array.sort;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description 插入排序 时间复杂度O(n^2)
 * @date 2018年07月17日 15:50
 */
public class InsertSort {
    /**
     * 容易忘记，所以选择下面那个简单点的
     * @param arr
     */
    public static void insertSort1(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            int tmp = arr[i];
            //落地标识，防止待插入的数最小
            boolean flag = false;
            for(int j = i -1; j >= 0; j--){
                if(tmp >= arr[j]){
                    arr[j+1] = tmp;
                    flag = true;
                    break;
                }else{
                    arr[j + 1] = arr[j];
                }
            }
            if(!flag){
                arr[0] = tmp;
            }
        }
    }

    public static void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            int tmp = arr[i];
            int j = i;
            while(j > 0 && tmp < arr[j - 1]){
                arr[j] = arr[j - 1];
                j-- ;
            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr={6,3,8,2,9,1};
        insertSort(arr);
        for(int data: arr)
            System.out.println(data);
    }
}
