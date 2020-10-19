package com.example.poi;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/13 13:47
 * @description：
 */
@Data
@NoArgsConstructor
public class ExcelData {
    private Integer id;
    private String status;
    private String name;
    private String type;
    private String level;
    private Long phone;
    private String content;
    private Double invest;
    private Double apply;
    private Double estimate;
    private Double proposed;
    private Double actual;
    private String province;
    private String city;
    private String district;
    private String isPoor;
    private String isFarm;
    private String products;
    private LocalDateTime create;
    private LocalDateTime update;
    private String status2;
}
