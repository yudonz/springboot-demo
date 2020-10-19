package com.example.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/21 17:26
 * @description：
 */
@Data
public class ResourceRead {
    @ExcelProperty(value = {"aid"}, index = 0)
    private Integer aid;
    @ExcelProperty(value = {"一级菜单"}, index = 1)
    private String aname;
    @ExcelProperty(value = {"bid"}, index = 2)
    private Integer bid;
    @ExcelProperty(value = {"二级菜单"}, index = 3)
    private String bname;
    @ExcelProperty(value = {"cid"}, index = 4)
    private Integer cid;
    @ExcelProperty(value = {"按钮"}, index = 5)
    private String cname;
    @ExcelProperty(value = {"按钮"}, index = 6)
    private String artelprovince;
    @ExcelProperty(value = {"按钮"}, index = 7)
    private String artelcity;

}
