package com.abu.jdk.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何将非线程安全的容器 封装为线程安全
 * 1种方法: 封装在类内部, 控制访问
 * <p>
 * JDK 提供的方法
 * List list = Collections.synchronizedList(new ArrayList());
 * Set set   = Collections.synchronizedSet(new HashSet());
 * Map map   = Collections.synchronizedMap(new HashMap());
 *
 * @param <T>
 */
public class SafeArrayList<T> {

    // 封装 ArrayList
    List<T> c = new ArrayList<>();

    // 控制访问路径
    synchronized T get(int idx) {
        return c.get(idx);
    }

    synchronized void add(int idx, T t) {
        c.add(idx, t);
    }

    synchronized boolean addIfNotExist(T t) {
        if (!c.contains(t)) {
            c.add(t);
            return true;
        }
        return false;
    }

}
