package com.abu.jdk.concurrent.lock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {

    public void lock() {
        final StampedLock sl = new StampedLock();

        // 获取 / 释放悲观读锁示意代码
        long stamp = sl.readLock();
        try {
            // 省略业务相关代码
        } finally {
            sl.unlockRead(stamp);
        }

        // 获取 / 释放写锁示意代码
        long stamp2 = sl.writeLock();
        try {
            // 省略业务相关代码
        } finally {
            sl.unlockWrite(stamp2);
        }

    }
}
