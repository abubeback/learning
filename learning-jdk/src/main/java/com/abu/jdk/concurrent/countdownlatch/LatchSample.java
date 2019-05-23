package com.abu.jdk.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 排队问题: 10个人排队, 5人1个批次前进
 * 思路. init(6), 5个线程countdown, 5个线程wait; 主线程countdown, 5个wait线程前进
 */
public class LatchSample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(6);
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new FirstBatchWorker(latch));
            t.start();
        }
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new SecondBatchWorker(latch));
            t.start();
        }
        // 注意：这里是演示目的的逻辑，并不是推荐的协调方式
        while (latch.getCount() != 1) {
            Thread.sleep(100L);
        }
        System.out.println("Wait for first batch finish");
        latch.countDown();
    }

    static class FirstBatchWorker implements Runnable {
        private CountDownLatch latch;

        public FirstBatchWorker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("First batch executed!");
            latch.countDown();
        }
    }

    static class SecondBatchWorker implements Runnable {
        private CountDownLatch latch;

        public SecondBatchWorker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
                System.out.println("Second batch executed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}