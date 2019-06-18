package com.abu.jdk.concurrent.lock;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedQueue<T> {

    Queue<T> queue = new ArrayDeque<>();

    final Lock lock = new ReentrantLock();
    // 条件变量：队列不满
    final Condition notFull = lock.newCondition();
    // 条件变量：队列不空
    final Condition notEmpty = lock.newCondition();

    // 入队
    void enq(T x) throws InterruptedException{
        lock.lock();
        try {
            while (queue.size() == 10) {
                // 等待队列不满
                notFull.await();
            }
            // 省略入队操作...
            queue.add(x);
            // 入队后, 通知可出队
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    // 出队
    void deq() throws InterruptedException{
        lock.lock();
        try {
            while (queue.size() == 0) {
                // 等待队列不空
                notEmpty.await();
            }
            // 省略出队操作...
            queue.poll();
            // 出队后，通知可入队
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
