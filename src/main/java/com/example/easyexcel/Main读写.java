package com.example.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.example.entity.ResourceRead;

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
        EasyExcel.read(fileName, ResourceRead.class, new ResourceListener(null)).sheet().doRead();
    }

    public static void simpleRead() {
        String fileName = "D:\\project\\农业农村部政府管理平台.xlsx";
        EasyExcel.read(fileName, ExcelData.class, new ExcelDataListener(null)).sheet(2).doRead();
    }
}
