package com.abu.jdk.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原题: 限流100个访问量
 * 方法接口限流100个并发数问题
 * 从限流类型来说一般来说分为两种:并发数限流和QPS限流(QueryPerSecond)
 * 这里考虑第1种限流, 利用变量保存请求数量的3种方法
 *
 * 扩展问题, QPS限流问题:
 * https://juejin.im/post/5c456960f265da611801fc93#heading-1
 */
public class ConcurrencyLimit {

    /**
     * 方法1
     * synchronized 代码块加锁, 当前对象需要单例模式
     */
    int maxRequest = 100;
    int nowRequest = 0;

    public void request1() {
        if (nowRequest >= maxRequest) {
            return;
        }
        synchronized (this) {
            if (nowRequest >= maxRequest) {
                return;
            }
            nowRequest++;
        }

        //调用接口
        try {
            invokeXXX();
        } finally {
            synchronized (this) {
                nowRequest--;
            }
        }
    }

    /**
     * 方法2:
     * 使用 AtomicInteger 类
     */

    int maxRequest2=100;
    AtomicInteger nowRequest2 =new AtomicInteger(0);

    public void request2(){
        for(;;){
            int currentReq=nowRequest2.get();
            if(currentReq>=maxRequest2){
                return;
            }
            if(nowRequest2.compareAndSet(currentReq,currentReq+1)){
                break;
            }
        }

        //调用接口
        try{
            invokeXXX();
        }finally{
            nowRequest2.decrementAndGet();
        }
    }

    /**
     * 方法3:
     * 使用信号量对象 Semaphore
     */
    int maxRequest3=100;
    Semaphore reqSemaphore = new Semaphore(maxRequest3);

    public void request(){
        if(!reqSemaphore.tryAcquire()){
            return ;
        }

        //调用接口
        try{
            invokeXXX();
        }finally{
            reqSemaphore.release();
        }
    }

    private void invokeXXX() {

    }

}
