package com.example.demo.easyexcel;

import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/19 18:05
 * @description：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class ResourceMapperTest {

    @Autowired
    private ResourceMapper resourceMapper;

    @Test
    void findAll() {
        List<Resource> all = resourceMapper.findAll();
        all.forEach(System.out::println);

        String fileName = "D:\\project\\农业农村部政府管理平台.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, ExcelData.class, new ExcelDataListener(null)).sheet(2).doRead();
    }
}