package com.example.mapper;

import com.example.entity.People;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
    void findAllPeople() {
        List<People> people = peopleMapper.findAllPeople();
        people.forEach(System.out::println);
    }

    @Test
    void selectByPrimaryKey() {
        People people = peopleMapper.selectByPrimaryKey(1);
        System.out.println(people);
    }

    @Test
    void findById() {
        People test = peopleMapper.findById(1);
        System.out.println(test);
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