package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}