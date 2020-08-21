package com.example.demo.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/19 15:15
 * @description：
 */
@Data
public class ExcelData {
    @ExcelProperty(value = {"职能部门", "职能部门", "职能部门", "职能部门"}, index = 0)
    private String dept;
    @ExcelProperty(value = {"范围", "范围", "范围", "范围"}, index = 1)
    private String range;
    @ExcelProperty(value = {"岗位", "岗位", "岗位", "岗位"}, index = 2)
    private String post;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "经营主体", "查询"}, index = 14)
    private String manageQuery;

    @ExcelProperty(value = {"栏目权限", "经营主体管理", "经营主体", "查看"}, index = 15)
    private String manageRead;

    @ExcelProperty(value = {"栏目权限", "经营主体管理", "经营主体", "导出excel文件"}, index = 16)
    private String manageExport;

    @ExcelProperty(value = {"栏目权限", "经营主体管理", "经营主体", "取消评级"}, index = 17)
    private String cancel;

    @ExcelProperty(value = {"栏目权限", "经营主体管理", "待初审(待审核主体)", "查询"}, index = 18)
    private String trialQuery;

    @ExcelProperty(value = {"栏目权限", "经营主体管理", "待初审(待审核主体)", "查看"}, index = 19)
    private String trialRead;

    @ExcelProperty(value = {"栏目权限", "经营主体管理", "待初审(待审核主体)", "审核"}, index = 20)
    private String trialVerify;

    @ExcelProperty(value = {"栏目权限", "经营主体管理", "初审驳回（已退回主体）", "查询"}, index = 21)
    private String rejectQuery;

    @ExcelProperty(value = {"栏目权限", "经营主体管理", "初审驳回（已退回主体）", "导出"}, index = 22)
    private String rejectExport;

    @ExcelProperty(value = {"栏目权限", "经营主体管理", "初审驳回（已退回主体）", "查看"}, index = 23)
    private String rejectRead;

    @ExcelProperty(value = {"栏目权限", "经营主体管理", "认证通过(已认证主体)", "查询"}, index = 24)
    private String rztgQuery;

    @ExcelProperty(value = {"栏目权限", "经营主体管理", "认证通过(已认证主体)", "查看"}, index = 25)
    private String rztgRead;

    @ExcelProperty(value = {"栏目权限", "经营主体管理", "认证通过(已认证主体)", "服务数据"}, index = 26)
    private String rztgData;

    @ExcelProperty(value = {"栏目权限", "经营主体管理", "认证通过(已认证主体)", "复审凭证"}, index = 27)
    private String rztgFs;


}
