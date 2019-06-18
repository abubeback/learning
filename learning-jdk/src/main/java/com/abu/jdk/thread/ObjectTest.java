package com.abu.jdk.thread;

public class ObjectTest {
    public static void main(String[] args) {
        final Object lock = new Object();

        new Thread(){

            public void run(){
                synchronized (lock){
                    try{
                        Thread.sleep(1000);
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(){
            public void run(){
                synchronized (lock){
                    lock.notify();
                }
            }
        }.start();
    }
}
