package com.abu.jdk.concurrent.common;

/**
 * 1.多核cpu导致的cpu缓存数据的可见性问题
 * 2.线程切换带来的原子性问题
 */
public class AddTest {
    public static long count = 0;

    private void add10K(String thread) {
        int idx = 0;
        while (idx++ < 10000) {
            //System.out.println(thread+":"+count);
            count += 1;

        }
    }

    public static void main(String[] args) {
        long count = AddTest.calc();
        System.out.println(count);
    }

    public static long calc(){
        final AddTest test = new AddTest();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(() -> {
            System.out.println("th1:"+AddTest.count);
            test.add10K("th1");
            System.out.println("th1:"+AddTest.count);
        });
        Thread th2 = new Thread(() -> {
            System.out.println("th2:"+AddTest.count);
            test.add10K("th2");
            System.out.println("th2:"+AddTest.count);
        });

        // 启动两个线程
        th1.start();
        System.out.println(AddTest.count);
        th2.start();
        System.out.println(AddTest.count);
        // 等待两个线程执行结束
        try {
            System.out.println(AddTest.count);
            th1.join();
            System.out.println(AddTest.count);
            th2.join();
            System.out.println(AddTest.count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return count;
    }
}
