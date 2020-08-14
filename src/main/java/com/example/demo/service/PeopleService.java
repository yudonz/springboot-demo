package com.example.demo.service;

import com.example.demo.entity.People;
import com.example.demo.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return peopleMapper.findAllPeople();
    }

    public People selectByPrimaryKey(Integer id) {
        return peopleMapper.selectByPrimaryKey(id);
    }

    public int insert(People record) {
        return peopleMapper.insertSelective(record);
    }

    public void save(People people) {
        peopleMapper.updateByPrimaryKeySelective(people);
    }


}



