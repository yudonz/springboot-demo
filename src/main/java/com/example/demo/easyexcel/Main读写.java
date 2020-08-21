package com.example.demo.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.example.demo.entity.ResourceRead;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/19 15:44
 * @description：
 */
public class Main读写 {
    public static void main(String[] args) {

        //simpleRead();
        getResource();

    }

    private static void getResource() {
        String fileName = "D:\\project\\prd-权限模板.xlsx";
        EasyExcel.read(fileName, ResourceRead.class, new ResourceListener()).sheet().doRead();
    }

    public static void simpleRead() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = "D:\\project\\农业农村部政府管理平台.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, ExcelData.class, new ExcelDataListener(null)).sheet(2).doRead();
    }
}
