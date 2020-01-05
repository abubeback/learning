package com.abu.jdk.tryfin;

public class FinallyTest5 {
    public static void main(String[] args) {
        System.out.println(test4());
    }

    /**
     * Output:
     * try block
     * catch block
     * finally block
     * b greater than 25, b = 35
     * 85
     * @return
     * 外部return, 经过所有流程
     */
    public static int test4() {
        int b = 20;
        try {
            System.out.println("try block");
            b = b / 0;
            return b += 80;
        } catch (Exception e) {
            b += 15;
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
            b += 50;
        }
        return b;
    }

    public static int test5(int b){
        b += 30;
        return b;
    }
}
