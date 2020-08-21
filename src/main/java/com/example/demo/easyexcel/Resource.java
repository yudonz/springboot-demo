package com.example.demo.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/19 17:52
 * @description：
 */
@Data
@NoArgsConstructor
public class Resource {
    @ExcelProperty(value = "id")
    private Integer aid;
    @ExcelProperty(value = "一级菜单")
    private String aname;
    @ExcelProperty(value = "类型")
    private String aResourceType;
    @ExcelProperty(value = "id")
    private Integer bid;
    @ExcelProperty(value = "二级菜单")
    private String bName;
    @ExcelProperty(value = "类型")
    private Integer bResourceType;
    @ExcelProperty(value = "id")
    private Integer cid;
    @ExcelProperty(value = "按钮")
    private String cName;
    @ExcelProperty(value = "类型")
    private Integer cResourceType;
}
