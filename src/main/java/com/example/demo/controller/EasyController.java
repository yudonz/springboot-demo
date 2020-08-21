package com.example.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.example.demo.easyexcel.ExcelData;
import com.example.demo.easyexcel.ExcelDataListener;
import com.example.demo.easyexcel.Resource;
import com.example.demo.easyexcel.ResourceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/19 18:17
 * @description：
 */
@Slf4j
@RestController
public class EasyController {
    @Autowired
    private ResourceMapper resourceMapper;

    @GetMapping("/readExcel")
    public void fun() {
        List<Resource> all = resourceMapper.findAll();

        String fileName = "D:\\project\\农业农村部政府管理平台.xlsx";
        EasyExcel.read(fileName, ExcelData.class, new ExcelDataListener(all)).sheet(2).doRead();
    }

    @GetMapping("/export")
    public void export() {
        List<Resource> all = resourceMapper.findAll();
        all.forEach(System.out::println);
        String fileName = "C:\\Users\\Administrator\\Desktop\\菜单权限.xls";
        EasyExcel.write(fileName, Resource.class).sheet("模板").doWrite(all);
    }
}
