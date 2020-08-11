package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/5 13:39
 * @description：${description}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "people")
public class People implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    private static final long serialVersionUID = 1L;

    public People(String name) {
        this.name = name;
    }
}