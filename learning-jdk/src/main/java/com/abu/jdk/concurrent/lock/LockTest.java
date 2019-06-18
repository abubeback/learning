package com.abu.jdk.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(ticket, "1号窗口").start();
        new Thread(ticket, "2号窗口").start();
        new Thread(ticket, "3号窗口").start();

    }
}

class Ticket implements Runnable {

    private volatile int ticket = 100;
    // ReentrantLock 可重入锁  Lock接口的实现类之一
    private Lock lock = new ReentrantLock(true);

    @Override
    public void run() {

        while (true) {
            try {
                lock.lock();
                //放大多线程问题
                Thread.sleep(200);
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " 完成售票，余票为：" + --ticket);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //保证锁的释放
                lock.unlock();
            }
        }

    }
}
