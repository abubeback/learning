package com.abu.jdk.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 排队问题, 5人1组
 * 思路: 利用 CyclicBarrier 可重用的特性, 5个worker 会集体等待3次并运行额外线程的方法
 */
public class CyclicBarrierSample {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("Action...GO again!");
            }
        });
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new CyclicWorker(i, barrier));
            t.start();
        }
    }

    static class CyclicWorker implements Runnable {
        private int index;
        private CyclicBarrier barrier;

        public CyclicWorker(int index, CyclicBarrier barrier) {
            this.index = index;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Executed in worker-"+index);
                    barrier.await();
                }
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
