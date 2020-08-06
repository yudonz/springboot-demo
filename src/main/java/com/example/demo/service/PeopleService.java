package com.example.demo.service;

import com.example.demo.entity.People;
import com.example.demo.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/3 16:56
 * @description：
 */
@Service
public class PeopleService {
    @Autowired
    private PeopleMapper peopleMapper;

    public List<People> findAll()  {
        List<People> allPeople = peopleMapper.findAllPeople();
        return allPeople;
    }

    public People selectByPrimaryKey(Integer id) {
        People people = peopleMapper.selectByPrimaryKey(id);
        return people;
    }

    public int insert(People record) {
        return peopleMapper.insert(record);
    }

    public int updateBatch(List<People> list) {
        return peopleMapper.updateBatch(list);
    }

    public int batchInsert(List<People> list) {
        return peopleMapper.batchInsert(list);
    }
}



