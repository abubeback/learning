package com.abu.jdk.parent;

public class Child extends Base{
    public Child(){
        // 默认访问父类的空参构造方法, 如无则有2solution
        // 1.super
        // 2.this
        // super/this语句必须出现在构造方法第一句, 不能出现多句
        this(1);
        System.out.println("I'm child");
    }
    public Child(int i){
        super(i);
        System.out.println("I'm child");
    }

    public static void main(String[] args) {
        Base child = new Child();
    }
}
