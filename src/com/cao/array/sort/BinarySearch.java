package com.cao.array.sort;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2018年07月08日 17:11
 */
public class BinarySearch {
    public int binarySearch(int[]arr, int key){
        if(arr == null || arr.length == 0)
            return -1;
        int min = 0;
        int max = arr.length-1;
        while(min<=max){
            int idx = min+(max-min)/2;
            if(arr[idx]>key){
                max = idx-1;
            }else if(arr[idx]<key){
                min = idx+1;
            }else{
                return idx;
            }
        }
        return -1;
    }

    /**
     * 和上边的边界不一样，[min,max)
     * @param arr
     * @param key
     * @return
     */
    public int binarySearch2(int[]arr, int key){
        if(arr == null || arr.length == 0)
            return -1;
        int min = 0;
        int max = arr.length;
        while(min<max){
            int idx = min+(max-min)/2;
            if(arr[idx]>key){
                max = idx;
            }else if(arr[idx]<key){
                min = idx+1;
            }else{
                return idx;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        System.out.println(search.binarySearch(new int[]{1,2,10,15,50,100},10));
        System.out.println(search.binarySearch(new int[]{1,2,10,15,50,100},15));
        System.out.println(search.binarySearch(new int[]{1,2,10,15,100},15));
        System.out.println(search.binarySearch(new int[]{1,2,10,15,100},0));
        System.out.println(search.binarySearch(new int[]{1,2,10,15,100},1000));
        System.out.println(search.binarySearch(new int[]{1,2,10,15,100},13));
        System.out.println("================");
        System.out.println(search.binarySearch(new int[]{},13));
        System.out.println(search.binarySearch(new int[]{12},13));
        System.out.println(search.binarySearch(new int[]{13},13));
        System.out.println(search.binarySearch(new int[]{15},13));
        System.out.println("================");
        System.out.println(search.binarySearch(new int[]{12,13},13));
        System.out.println(search.binarySearch(new int[]{12,13},12));
        System.out.println(search.binarySearch(new int[]{12,13},10));
        System.out.println(search.binarySearch(new int[]{12,13},15));
    }
}
