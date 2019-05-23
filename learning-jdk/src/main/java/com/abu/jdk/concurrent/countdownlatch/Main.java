package com.abu.jdk.concurrent.countdownlatch;

/**
 * http://www.importnew.com/15731.html
 * https://howtodoinjava.com/java/multi-threading/when-to-use-countdownlatch-java-concurrency-example-tutorial/
 *
 * Latch: 门闩shuan
 * CountDownLatch 是通过一个计数器来实现的，计数器的初始值为线程的数量。每当一个线程完成了自己的任务后，计数器的值就会减1。
 * 当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。
 *
 * Q&A
 * 1.解释一下 CountDownLatch 概念?
 *   1个初始化计数器,当计数为0时，await的所有线程解除闭锁
 * 2.CountDownLatch 和 CyclicBarrier 的不同之处?
 *   1.cdl 不能重置, cb 自动或手动重置
 *   2.cdl 操作方式 await/countDown, cb 操作方式 await
 *   3.cb 有 BrokenBarrierException, 当await超时或手动reset时, waiting的线程抛出并越过barrier
 * 3.给出一些CountDownLatch使用的例子?
 *   1)实现最大的并行性：有时我们想同时启动多个线程，实现最大程度的并行性。例如，我们想测试一个单例类。
 *   如果我们创建一个初始计数为1的CountDownLatch，并让所有线程都在这个锁上等待，那么我们可以很轻松地完成测试。
 *   我们只需调用 一次countDown()方法就可以让所有的等待线程同时恢复执行。
 *   2)开始执行前等待n个线程完成各自任务：例如应用程序启动类要确保在处理用户请求前，所有N个外部系统已经启动和运行了。
 *   3?)死锁检测：一个非常方便的使用场景是，你可以使用n个线程访问共享资源，在每次测试阶段的线程数目是不同的，并尝试产生死锁。
 *
 *   快速记忆: (N)主线程阻塞,子线程countdown;(1)子线程await,主线程countdown;
 * 4.CountDownLatch 类中主要的方法?
 *   countDown() /getCount()
 *   await()
 *   await(long, TimeUnit)
 */
public class Main {
    public static void main(String[] args)
    {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: "+ result);
    }
}