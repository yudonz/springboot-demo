package com.example.demo.controller;

import com.example.demo.entity.People;
import com.example.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/4 16:42
 * @description：
 */
@Controller
public class People2Controller {
    @Autowired
    private PeopleService peopleService;

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("/selectAll2")
    public ModelAndView findAllPeople(Integer pageNum, Integer pageSize, String name, Integer isShow, String top, Integer id) {
        List<People> all = peopleService.findAll();
        ModelAndView mv = new ModelAndView("people");
        mv.addObject("people", all);
        return mv;
    }


}
