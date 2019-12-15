package com.abu.algo.common.sort.bucket;

import java.util.Scanner;

/**
 * Created by zhewawan on 2019/12/9
 * 桶排序, 每个桶中保存的是数字出现的次数，事先需要知道桶数字的范围，如[0-100]
 */
public class BucketSort {

    private int[] bucketArray;

    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        int[] inputArray = bucketSort.input();
        bucketSort.sort(inputArray);
        bucketSort.print();
    }

    private int[] input(){
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入数字个数: ");
        int count = scan.nextInt();

        int [] input = new int[count];

        for(int i=0;i<count;i++){
            System.out.print("数字"+(i+1)+": ");
            input[i] = scan.nextInt();
        }
        return input;
    }

    // 返回桶数组
    private void sort(int[] inputArray){
        bucketArray = new int[101];
        for(int input : inputArray){
            bucketArray[input]++;
        }
    }

    // 输出，asc
    private void print(){
        for(int i=100;i>=0;i--){
            if(bucketArray[i]!=0){
                int times = bucketArray[i];
                for(int j=0;j<times;j++){
                    System.out.print(i+",");
                }
            }
        }
    }
}
