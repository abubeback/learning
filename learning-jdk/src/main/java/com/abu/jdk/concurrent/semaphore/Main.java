package com.abu.jdk.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * https://howtodoinjava.com/java/multi-threading/control-concurrent-access-to-multiple-copies-of-a-resource-using-semaphore/
 *
 * 常用方法: 构造方法(n);构造方法(n,fair);acquire();release();availablePermits()
 */
public class Main {
    public static void main(String[] args) {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for(int i=0;i<N;i++)
            new Worker(i,semaphore).start();
    }
 
    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }
 
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(semaphore.availablePermits());
                System.out.println("工人"+this.num+"占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人"+this.num+"释放出机器");
                semaphore.release();           
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}