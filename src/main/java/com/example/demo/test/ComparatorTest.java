package com.example.demo.test;

import com.example.demo.entity.People;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public class ComparatorTest {
    public static void main(String[] args) {

        List<People> list = new ArrayList<>();
        list.add(new People(1,"张三", LocalDateTime.now()));
        list.add(new People(22,"李四", LocalDateTime.now()));
        list.add(new People(4,"王五", LocalDateTime.now()));
        list.add(new People(3,"赵六", LocalDateTime.now()));

        Collections.sort(list, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.getId()-o2.getId();
            }
        });

        //lambda
        Collections.sort(list, (o1, o2) -> o1.getId()-o2.getId());

        //Comparator.comparingInt
        Collections.sort(list, Comparator.comparingInt(People::getId));

        list.stream().forEach(System.out::println);
        //list.stream().sorted(Comparator.comparing(p->p.getId())).forEach(System.out::println);

        list.stream().min(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.getId()-o2.getId();//从小到大
            }
        }).get();
    }
}
