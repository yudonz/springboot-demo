package com.example.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.example.demo.easyexcel.ExcelData;
import com.example.demo.easyexcel.ExcelDataListener;
import com.example.demo.easyexcel.Resource;
import com.example.demo.easyexcel.ResourceListener;
import com.example.demo.entity.ResourceRead;
import com.example.demo.mapper.AdmRightTemplateMapper;
import com.example.demo.mapper.ResourceMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/19 18:17
 * @description：
 */
@Slf4j
@RestController
@Api(description = "easyExcel测试")
public class EasyOldController {
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private AdmRightTemplateMapper admRightTemplateMapper;

    @ApiOperation(value = "数据库读取excel")
    @GetMapping("/readExcel")
    public void fun() {
        List<Resource> all = resourceMapper.findAll();

        String fileName = "D:\\project\\农业农村部政府管理平台.xlsx";
        EasyExcel.read(fileName, ExcelData.class, new ExcelDataListener(all)).sheet(2).doRead();
    }

    @ApiOperation(value = "写入到本地")
    @GetMapping("/export1")
    public void export() {
        List<Resource> all = resourceMapper.findAll();
        all.forEach(System.out::println);
        String fileName = "C:\\Users\\Administrator\\Desktop\\菜单权限.xls";
        EasyExcel.write(fileName, Resource.class).sheet("模板").doWrite(all);
    }

    @ApiOperation(value = "读取excel")
    @GetMapping("/readResource")
    public void readResource() {
        String fileName = "D:\\project\\prd-权限模板.xlsx";
        EasyExcel.read(fileName, ResourceRead.class, new ResourceListener(admRightTemplateMapper)).sheet().doRead();
    }

    @ApiOperation(value = "上传excel")
    @GetMapping("/upload")
    public void upload(@Param("file") MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ResourceRead.class, new ResourceListener(admRightTemplateMapper)).sheet().doRead();
    }


}
