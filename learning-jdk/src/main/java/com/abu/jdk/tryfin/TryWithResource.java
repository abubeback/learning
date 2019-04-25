package com.abu.jdk.tryfin;

import java.io.*;

/**
 * JDK 1.7 引入 try-with-resources, 资源需要实现AutoCloseable 接口
 * 类似python中的with
 */
public class TryWithResource {
    public static void main(String[] args) {
        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(new File("test.txt")));
             BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File("out.txt")))) {
            int b;
            while ((b = bin.read()) != -1) {
                bout.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}