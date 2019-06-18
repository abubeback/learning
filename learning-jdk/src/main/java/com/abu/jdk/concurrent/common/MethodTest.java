package com.abu.jdk.concurrent.common;

public class MethodTest {
    public static void main(String[] args) {
        int [] queue = MethodTest.fibonacci(5);
        int sum = sum(queue, 5);
        System.out.println(sum);
    }

    // 返回斐波那契数列
    private static int[] fibonacci(int n) {
        // 创建结果数组
        int[] r = new int[n];
        // 初始化第一、第二个数
        r[0] = r[1] = 1;  // ①
        // 计算 2..n
        for(int i = 2; i < n; i++) {
            r[i] = r[i-2] + r[i-1];
        }
        return r;
    }

    /**
     * 方式一：递归，传数组长度
     * @param arr
     * @param n
     * @return
     */
    private static int sum(int arr[], int n) {
        if(n == 1) {
            return arr[0];
        }else {
            return arr[n-1] + sum(arr, --n);
        }
    }
}
