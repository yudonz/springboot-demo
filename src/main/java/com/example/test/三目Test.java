package com.example.test;

import com.example.entity.People;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class 三目Test {
    private static List<People> list;
    private static Map<String, Object> map = new HashMap<>();

    public static void main(String[] args) {
        init();

        People people = list.get(0);
        log.info("people = {}", people);

        //Integer i = people.getId() == null ? -1 : people.getId();
        map.put("la", people != null ? people.getName() : -1);
    }

    private static void init() {
        if (list == null) {
            list = new ArrayList<>();
            list.add(new People());
        }
    }
}
