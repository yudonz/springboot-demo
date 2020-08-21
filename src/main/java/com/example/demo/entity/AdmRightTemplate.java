package com.example.demo.entity;


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
    /**
     * 部门id
     */
    @Column(name = "department_id")
    @ApiModelProperty(value = "部门id")
    private Integer departmentId;
    /**
     * 部门名称
     */
    @Column(name = "department_name")
    @ApiModelProperty(value = "部门名称")
    private String departmentName;
    /**
     * 0-部-1-省
     */
    @Column(name = "`level`")
    @ApiModelProperty(value = "0-部-1-省")
    private Byte level;
    /**
     * 资源id
     */
    @Column(name = "resource_id")
    @ApiModelProperty(value = "资源id")
    private Integer resourceId;
    /**
     * 资源名称
     */
    @Column(name = "resource_name")
    @ApiModelProperty(value = "资源名称")
    private String resourceName;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}