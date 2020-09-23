package com.abu.jdk.stream;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iwang
 * @since 2020/9/1
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("aaa", 40));
        persons.add(new Person("bbb", 20));
        persons.add(new Person("ccc", 40));
        persons.add(new Person("ddd", 40));

        int age = 40;
        Person p = persons.stream().reduce((p1, p2) -> {
            if (p2.getAge()==age) {
                return p2;
            } else if (p1 != null && p1.getAge()==age) {
                return p1;
            }
            return null;
        }).get();

        System.out.println(p.getName());
    }
}
