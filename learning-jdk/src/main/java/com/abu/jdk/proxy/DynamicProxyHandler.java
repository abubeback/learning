package com.abu.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的关键 InvocationHandler, 且readObject必须要有接口, 使用反射实现
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object realObject;
 
    public DynamicProxyHandler(Object realObject) {
        this.realObject = realObject;
    }
 
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理扩展逻辑
        System.out.println("proxy do");
        return method.invoke(realObject, args);
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        Action proxy = (Action) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Action.class}, new DynamicProxyHandler(realObject));
        proxy.doSomething();
    }
}