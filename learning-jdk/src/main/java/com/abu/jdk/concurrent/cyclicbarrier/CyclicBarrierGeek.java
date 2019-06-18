package com.abu.jdk.concurrent.cyclicbarrier;

import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * https://time.geekbang.org/column/article/89461
 *
 */
public class CyclicBarrierGeek {

    // 订单队列
    Vector<P> pos = new Vector<>();
    // 派送单队列
    Vector<D> dos = new Vector<>();

    void check() {
        P p = pos.remove(0);
        D d = dos.remove(0);
        // 执行对账操作
        //diff = check(p, d);
        // 差异写入差异库
        //save(diff);
    }

    void checkAll(CyclicBarrier barrier) {
        // 循环查询订单库
        Thread T1 = new Thread(() -> {
            while (hasPOrders()) {
                // 查询订单库
                pos.add(getPOrders());
                // 等待
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        T1.start();
        // 循环查询运单库
        Thread T2 = new Thread(() -> {
            //存在未对账订单
            while (hasDOrders()) {
                // 查询运单库
                dos.add(getDOrders());
                // 等待
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        T2.start();
    }

    private void main() {

        // 执行回调的线程池, 保证串行
        Executor executor = Executors.newFixedThreadPool(1);
        // 回调函数如果不另开线程, 将会在最后一个await的线程上执行, 且为同步方法
        final CyclicBarrier barrier =
                new CyclicBarrier(2, () -> {
                    executor.execute(() -> check());
                });
        checkAll(barrier);
    }

    private boolean hasPOrders() {
        return true;
    }

    private boolean hasDOrders() {
        return true;
    }

    private P getPOrders(){
        return new P();
    }

    private D getDOrders(){
        return new D();
    }

    class P {

    }

    class D {

    }
}
