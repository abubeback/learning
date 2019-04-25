package com.abu.jdk.tryfin;

public class FinallyTest3 {
    public static void main(String[] args) {
        System.out.println(test3());
    }

    /**
     * Output:
     * try block
     * finally block
     * b>25, b = 100
     * 100
     * @return
     * finally内部类似方法，值传递，内部参数为copy，值为副本赋值不改变外部，对象为引用，重新赋值不改变外部对象，可修改对象内部
     */
    public static int test3() {
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
            b = 150;
        }
        return 2000;
    }
}
