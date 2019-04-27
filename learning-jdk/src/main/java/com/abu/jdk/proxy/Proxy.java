package com.abu.jdk.proxy;

/**
 * 代理三要素: 共同接口,真实对象,代理对象
 * 静态代理, Proxy模式 example
 * 优点: 通过proxy持有realObject的引用, 并进行一层封装, 扩展功能, 不侵入原代码
 * 缺点: 类膨胀, 代理与真实类1对1
 *
 * 动态代理解决该问题
 */
public class Proxy implements Action {
    private Action realObject;
 
    public Proxy(Action realObject) {
        this.realObject = realObject;
    }
    public void doSomething() {
        System.out.println("proxy do");
        realObject.doSomething();
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealObject());
        proxy.doSomething();
    }
}