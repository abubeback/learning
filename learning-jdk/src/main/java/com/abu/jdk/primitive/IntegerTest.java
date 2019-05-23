package com.abu.jdk.primitive;

/**
 * == 为堆内存地址比较, Integer维持1个数值在[-128,127]的cache，这些cache引用对Integer对象地址是不变的
 * 但是不在这个范围内的数字，则new Integer(i) 这个地址是新的地址，内存地址不可能
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer f1 = 100;
        Integer f2 = 100;
        Integer f3 = 150;
        Integer f4 = 150;
        // inside cache
        System.out.println(f1 == f2);//output true
        // outside cache
        System.out.println(f3 == f4);//output false
        //Integer 与 int == 比较, Integer会被拆箱
        System.out.println(f4 == 150);//output true
    }
}
