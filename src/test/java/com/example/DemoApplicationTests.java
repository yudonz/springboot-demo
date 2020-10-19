package com.example;

import com.example.entity.People;
import com.example.service.PeopleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private PeopleService peopleService;

    @Test
    void findAll() {
        List<People> all = peopleService.findAll();
        all.forEach(System.out::println);
    }

}
