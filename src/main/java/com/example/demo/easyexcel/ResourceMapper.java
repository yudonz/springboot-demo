package com.example.demo.easyexcel;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/19 17:54
 * @description：
 */
@Mapper
public interface ResourceMapper {
    List<Resource> findAll();
}
