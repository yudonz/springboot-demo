package com.example.demo.controller;

import com.example.demo.entity.People;
import com.example.demo.service.PeopleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/4 16:42
 * @description：
 */
@RestController
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @GetMapping("/hi/{id}")
    public People hello(@PathVariable("id") Integer id) {
        People people = peopleService.selectByPrimaryKey(id);
        return people;
    }

    @GetMapping("/selectAll")
    public PageInfo<People> findAllPeople(Integer pageNum, Integer pageSize, String name, Integer isShow, String top, Integer id) {
//        pageNum = pageNum == null ? 1 : pageNum;
//        pageSize = pageSize == null ? 3 : pageSize;
//        PageHelper.startPage(pageNum,pageSize,"id");
        List<People> all = peopleService.findAll();
        PageInfo pageInfo = new PageInfo(all);
        return pageInfo;
    }

    //添加或编辑
    @PostMapping("/addPeople")
    public People addPeople(@RequestBody People people) {
        System.out.println(people);
        if (people.getId() == null) {
            peopleService.insert(people);
        } else {
            peopleService.save(people);
        }
        return people;
    }
}
