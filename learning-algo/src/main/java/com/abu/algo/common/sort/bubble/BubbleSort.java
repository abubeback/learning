package com.abu.algo.common.sort.bubble;

/**
 * Created by zhewawan on 2019/12/15
 * 冒泡排序, 双重循环
 */
public class BubbleSort {

    public static void main(String[] args) {
        int [] test = new int[]{7,9,5,3,1};
        int [] result = bubbleSort(test);
        for(int i : result){
            System.out.print(i+",");
        }
    }

    /**
     * 从小到大排序, 大数冒泡至数组尾部
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        int size = array.length;
        int tmp;
        for(int i=size-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(array[j]>array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }

        return array;
    }
}
