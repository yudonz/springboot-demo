package com.example.service;

import com.example.entity.People;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/3 16:58
 * @description：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class PeopleServiceTest {
    @Autowired
    private PeopleService peopleService;

    @Test
    void findAll() {
        List<People> all = peopleService.findAll();
        all.forEach(System.out::println);
    }


}