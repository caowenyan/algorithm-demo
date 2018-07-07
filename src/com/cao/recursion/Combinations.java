package com.cao.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description 求组合
 * @date 2018年07月07日 15:47
 */
public class Combinations {
    List<List<Integer>> result;
    public List<List<Integer>> combinations(List<Integer> data, int n){
        result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>(n);
        combinations(data, n, 0, tmp);
        return result;
    }

    private void combinations(List<Integer> data, int n, int index, List<Integer> tmp) {
        if(n == 0){
            //开始这里没有copy，导致所有的tmp都是null，所以这种时候要认真分析引用
            result.add(new ArrayList<>(tmp));
            return;
        }
        //无可用的结果
        if(data == null || index == data.size()){
            return;
        }
        tmp.add(data.get(index));
        combinations(data, n-1, index+1, tmp);
        tmp.remove(tmp.size()-1);
        combinations(data, n, index+1, tmp);
    }

    public void printCombinations(List<Integer>data, int n){
        List<List<Integer>> tmp = combinations(data,n);
        for(List<Integer> item:tmp){
            System.out.println(Arrays.toString(item.toArray()));
        }
        System.out.println("=============");
    }
    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.printCombinations(null,0);
        combinations.printCombinations(Arrays.asList(1),0);
        combinations.printCombinations(Arrays.asList(1),1);
        combinations.printCombinations(Arrays.asList(1,2,3,4,5),0);
        combinations.printCombinations(Arrays.asList(1,2,3,4,5),1);
        combinations.printCombinations(Arrays.asList(1,2,3,4,5),2);
        combinations.printCombinations(Arrays.asList(1,2,3,4,5,6,7,8,9,10),2);
        combinations.printCombinations(Arrays.asList(1,2,3,4,5,6,7,8,9,10),4);
    }
}
