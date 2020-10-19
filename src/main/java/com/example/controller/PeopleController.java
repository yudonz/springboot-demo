package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.People;
import com.example.service.PeopleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/4 16:42
 * @description：
 */
@Slf4j
@RestController
@Api(description = "人员测试接口")
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @GetMapping("/hi/{id}")
    public People hello(@PathVariable("id") Integer id) {
        People people = peopleService.selectByPrimaryKey(id);
        log.info("查询结果：people:{}", JSON.toJSONString(people));
        return people;
    }

    @GetMapping("/selectAll")
    public PageInfo<People> findAllPeople(Integer pageNum, Integer pageSize, String name, Integer isShow, String top, Integer id) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 3 : pageSize;
        PageHelper.startPage(pageNum,pageSize,"id");
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
