package com.abu.jdk.tryfin;

public class FinallyTest2 {
    public static void main(String[] args) {
        System.out.println(test2());
    }

    /**
     * output:
     * try block
     * finally block
     * b greater than 25, b = 100
     * 200
     * @return
     * finally里的return直接返回了，不管try中是否还有返回语句
     */
    public static int test2() {
        int b = 20;
        try {
            System.out.println("try block");
            return b += 80;
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
            return 200;
        }
        // return b;
    }
}
