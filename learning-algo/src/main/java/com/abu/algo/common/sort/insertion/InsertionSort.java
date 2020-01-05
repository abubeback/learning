package com.abu.algo.common.sort.insertion;

/**
 * Created by iwang on 11/27/2019
 */
public class InsertionSort {

    public static int[] sort(int[] array){
        if(array == null || array.length<=1){
            return array;
        }
        int size = array.length;
        for(int i=1;i<size;i++){
            int tmp = array[i];
            int j = i-1;                //开始比较的index,直到0
            while(j>=0 && array[j]>tmp){//当比到最左边或者遇到比temp小的数据时，结束循环
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = tmp;
        }
        return array;
    }

    public static void print(int[] array){
        for(int i : array){
            System.out.print(i+",");
        }
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,3,5,7,9,3,4,5,8};
        int[] result = sort(array);
        print(result);
    }
}
