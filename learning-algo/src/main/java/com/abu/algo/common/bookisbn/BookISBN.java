package com.abu.algo.common.bookisbn;

import com.abu.algo.common.sort.quick.QuickSortV2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhewawan on 2019/12/22.
 * 啊哈算法, 第一章P21
 * 输入N个数字，可能重复，进行去重和排序输出
 * 两种思路：先去重再排序；先排序再去重
 * 1.如果输入数字有范围限制，如1-1000，使用桶排序
 * 2.数字范围较大，则使用快速排序后，在输出时去重
 */
public class BookISBN {

    public static void main(String[] args) {
        int[] isbnInput = new int[]{20,40,32,67,40,20,89,300,400,15};

        //Integer[] result = sortMethod1(isbnInput);
        //print(result);

        Integer[] result = sortMethod2(isbnInput);
        print(result);

    }

    // 桶排序, 数字范围已知，为1-1000
    public static Integer[] sortMethod1(int[] array){
        int [] bucket = new int[1000];
        for(int input : array){
            bucket[input] = 1;
        }

        List<Integer> result = new ArrayList();
        for(int i=1;i<1000;i++){
            if(bucket[i]==1){
                result.add(i);
            }
        }

        return result.toArray(new Integer[result.size()]);
    }

    // 快速排序后，输出时去重
    public static Integer[] sortMethod2(int[] array){
        QuickSortV2.quickSort(array, 0, array.length-1);

        List<Integer> result = new ArrayList();
        for(int i=0;i<array.length;i++){
            if(i==0){
                result.add(array[i]);
            }else{
                if(array[i]!=array[i-1]){
                    result.add(array[i]);
                }
            }
        }

        return result.toArray(new Integer[result.size()]);
    }

    public static void print(Integer[] array){
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

}
