package com.abu.algo.common.bookisbn;

/**
 * Created by zhewawan on 2019/12/23.
 * 数组模拟堆栈，判断回文数
 *
 */
public class StackArray {

    public static void main(String[] args) {
        String temp = "abba";
        String[] array = temp.split("");

        int last = array.length/2 - 1;
        int startScan = array.length%2 == 0 ? last+1 : last+2;

        String[] stack = new String[last+1];
        for(int i=0;i<stack.length;i++){
            stack[i] = array[i];
        }
        // 回文判断开始,
        int index = stack.length-1;
        while(startScan<=array.length-1){
            if(!array[startScan].equals(stack[index])){
                break;
            }
            startScan++;
            index--;
        }

        if(index == -1){
            System.out.printf("It's 回文.");
        }else{
            System.out.println("It's not.");
        }
    }
}
