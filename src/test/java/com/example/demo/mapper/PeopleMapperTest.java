package com.example.demo.mapper;

import com.example.demo.entity.People;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/4 16:21
 * @description：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class PeopleMapperTest {
    @Autowired
    private PeopleMapper peopleMapper;

    @Test
    void fun(){
        People people=new People();
        people.setName("赵云");
        List<People> select = peopleMapper.select(people);
        System.out.println(select);
    }

    @Test
    void fun1(){
        List<People> people = peopleMapper.findAllPeople();
        people.forEach(System.out::println);
        System.out.println("---------------");
        People test = peopleMapper.findById(1);
        System.out.println(test);
    }

    @Test
    void fun2() {
        People people = peopleMapper.selectByPrimaryKey(1);
        System.out.println(people);
    }

    @Test
    void test() {
        People test = peopleMapper.findById(1);
        System.out.println(test);
    }

    @Test
    void test2() {
        List<Integer> ids = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(ids);
        List<People> byIds = peopleMapper.findByIds("1,2,3");
        System.out.println(byIds);
    }

    @Test
    void test3() {
        List<People> list = new ArrayList<>();
        list.add(new People("赵云1"));
        list.add(new People("赵云2"));
        int insert = peopleMapper.insert2(list);
        System.out.println(insert);
    }
}