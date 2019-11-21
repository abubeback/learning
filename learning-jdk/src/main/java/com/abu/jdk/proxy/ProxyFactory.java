package com.abu.jdk.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib 代理, 突破接口限制
 */
public class ProxyFactory implements MethodInterceptor {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public static void main(String[] args) {
        RealObject target = new RealObject();
        //ProxyFactory proxy = new ProxyFactory(target);
        //RealObject proxyInstance = (RealObject)proxy.getProxyInstance();
        RealObject proxyInstance = (RealObject) new ProxyFactory(target).getProxyInstance();
        proxyInstance.doSomething();
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类代理对象
        return en.create();
    }

    public Object intercept(Object obj, Method method, Object[] arg2, MethodProxy proxy) throws Throwable {
        System.out.println("开始事务...");
        Object returnValue = method.invoke(target, arg2);
        System.out.println("提交事务...");
        return returnValue;
    }

}