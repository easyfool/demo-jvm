package com.wangfengbabe.demo.jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Person {

    private String name;
    private int age;
    private List<Integer> address;

}

public class TestLoop {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        List<Person> persons = new ArrayList<>();

        while (true) {
            Person person = new Person("1", 25, list);
            TimeUnit.SECONDS.sleep(5);
            persons.add(person);

        }
    }

}
