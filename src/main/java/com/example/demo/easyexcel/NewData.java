package com.example.demo.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/19 15:15
 * @description：
 */
@Data
public class NewData {
    @ExcelProperty(value = {"职能部门", "职能部门", "职能部门", "职能部门"}, index = 0)
    private String dept;
    @ExcelProperty(value = {"范围", "范围", "范围", "范围"}, index = 1)
    private String range;
    @ExcelProperty(value = {"岗位", "岗位", "岗位", "岗位"}, index = 2)
    private String post;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "经营主体", "查询"}, index = 14)
    private String manageQuery;
    private Integer manageQueryId;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "经营主体", "查看"}, index = 15)
    private String manageRead;
    private Integer manageReadId;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "经营主体", "导出excel文件"}, index = 16)
    private String manageExport;
    private Integer manageExportId;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "经营主体", "取消评级"}, index = 17)
    private String cancel;
    private Integer cancelId;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "待初审(待审核主体)", "查询"}, index = 18)
    private String trialQuery;
    private Integer trialQueryId;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "待初审(待审核主体)", "查看"}, index = 19)
    private String trialRead;
    private Integer trialReadId;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "待初审(待审核主体)", "审核"}, index = 20)
    private String trialVerify;
    private Integer trialVerifyId;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "初审驳回（已退回主体）", "查询"}, index = 21)
    private String rejectQuery;
    private Integer rejectQueryId;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "初审驳回（已退回主体）", "导出"}, index = 22)
    private String rejectExport;
    private Integer rejectExportId;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "初审驳回（已退回主体）", "查看"}, index = 23)
    private String rejectRead;
    private Integer rejectReadId;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "认证通过(已认证主体)", "查询"}, index = 24)
    private String rztgQuery;
    private Integer rztgQueryId;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "认证通过(已认证主体)", "查看"}, index = 25)
    private String rztgRead;
    private Integer rztgReadId;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "认证通过(已认证主体)", "服务数据"}, index = 26)
    private String rztgData;
    private Integer rztgDataId;
    @ExcelProperty(value = {"栏目权限", "经营主体管理", "认证通过(已认证主体)", "复审凭证"}, index = 27)
    private String rztgFs;
    private Integer rztgFsId;


}
