package com.example.demo.easyexcel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/20 15:02
 * @description：
 */
public class Main导出测试 {
    public static void main(String[] args) {

        write();
        //writeSome();
    }

    private static void writeSome() {
        String fileName = "C:\\Users\\Administrator\\Desktop\\菜单权限.xls";
        List<Resource> list = getList();

        // 根据用户传入字段 假设我们要忽略 date
        Set<String> excludeColumnFiledNames = new HashSet<String>();
        excludeColumnFiledNames.add("date");
        EasyExcel.write(fileName, Resource.class).excludeColumnFiledNames(excludeColumnFiledNames).sheet("模板")
                .doWrite(list);

        // 根据用户传入字段 假设我们只要导出 date
        Set<String> includeColumnFiledNames = new HashSet<String>();
        includeColumnFiledNames.add("date");
        EasyExcel.write(fileName, Resource.class).includeColumnFiledNames(includeColumnFiledNames).sheet("模板")
                .doWrite(list);

        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, Resource.class).sheet("模板").doWrite(list);
    }

    private static void write() {
        String fileName = "C:\\Users\\Administrator\\Desktop\\菜单权限.xls";
        List<Resource> list = getList();

        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, Resource.class).sheet("模板").doWrite(list);
    }

    private static List<Resource> getList() {
        List<Resource> list = new ArrayList<>();
        Resource one = new Resource();
        one.setAid(1);
        one.setAname("aa");
        list.add(one);
        return list;
    }


}
