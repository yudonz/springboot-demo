package com.example.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/21 17:52
 * @description：${description}
 */
@ApiModel(value = "com-example-demo-entity-AdmRightTemplate")
@Data
@Table(name = "adm_right_template")
public class AdmRightTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "")
    private Integer id;

    @Column(name = "department_id")
    @ApiModelProperty(value = "部门id")
    private Integer departmentId;

    @Column(name = "department_name")
    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    @Column(name = "`level`")
    @ApiModelProperty(value = "0-部-1-省")
    private Byte level;

    @Column(name = "resource_id")
    @ApiModelProperty(value = "资源id")
    private Integer resourceId;

    @Column(name = "resource_name")
    @ApiModelProperty(value = "资源名称")
    private String resourceName;

    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}