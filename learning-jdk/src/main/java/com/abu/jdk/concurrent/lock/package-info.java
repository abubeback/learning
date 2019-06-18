/**
 * JDK并发包的核心的还是其对管程的实现
 * Lock 解决互斥问题
 * Condition 解决同步问题
 * //主要成员如下
 * Lock 接口
 * LockSupport
 * ReentrantLock
 * ReadWriteLock
 * ReentrantReadWriteLock 引入 读锁和写锁
 * StampedLock 引入 悲观读和乐观读
 */
package com.abu.jdk.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;