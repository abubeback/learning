package com.abu.jdk.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * http://www.importnew.com/21889.html
 * 4个线程都到达wait点后继续执行
 *
 * 常用方法: 构造方法(N);构造方法(N,Runnable);await();await(long, TimeUnit);reset()
 *
 * 使用场景: 所有线程执行到指定地点等待, 当所有线程都到达栅栏后，开放栅栏，一起继续执行，可指定开放栅栏时执行的额外线程
 */
public class Main {
    public static void main(String[] args) {
        int N = 4;
        //CyclicBarrier barrier  = new CyclicBarrier(N);
        CyclicBarrier barrier  = new CyclicBarrier(N,new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程"+Thread.currentThread().getName());
            }
        });

        for(int i=0;i<N;i++)
            new Writer(barrier).start();
    }
    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
 
        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}