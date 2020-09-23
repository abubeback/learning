package com.abu.jdk.stream;

/**
 *
 * @author iwang
 * @since 2020/9/1
 */
public class Person {

    private String name;
    private Integer age;

    public Person (String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
