package com.abu.jdk.tryfin;

public class FinallyTest {
    public static void main(String[] args) {
        System.out.println(test1());
    }

    /**
     * output:
     * try block
     * finally block
     * b>25, b = 100
     * 100
     * @return
     * try中的return语句先执行了但并没有立即返回，等到finally执行结束后再返回
     */
    public static int test1() {
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
        }
        return b;
    }
}
