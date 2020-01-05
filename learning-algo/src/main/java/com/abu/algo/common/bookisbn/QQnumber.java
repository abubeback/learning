package com.abu.algo.common.bookisbn;

/**
 * Created by zhewawan on 2019/12/23.
 * 啊哈算法，第一章，解密QQ号，提供号码为
 * 631758924，依次删除1个，至队尾1个，全部删除后，求删除的顺序
 * 结果为615947283
 */
public class QQnumber {

    public static void main(String[] args) {
        int [] array = init();
        int start = 0;
        int end = 9;

        StringBuilder sb = new StringBuilder(9);
        while(start<end){

            sb.append(array[start]);
            start ++;

            if(start<end){
                array[end] = array[start];
                end ++;
                start ++;
            }
        }
        System.out.println(sb);
    }

    private static int[] init(){
        int[] array = new int[100];
        array[0] = 6;
        array[1] = 3;
        array[2] = 1;
        array[3] = 7;
        array[4] = 5;
        array[5] = 8;
        array[6] = 9;
        array[7] = 2;
        array[8] = 4;
        return array;
    }
}
