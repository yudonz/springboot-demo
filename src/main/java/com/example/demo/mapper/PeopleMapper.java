package com.example.demo.mapper;

import com.example.demo.entity.People;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/5 13:39
 * @description：${description}
 */
public interface PeopleMapper extends Mapper<People> {
    int updateBatch(List<People> list);

    int batchInsert(@Param("list") List<People> list);

    List<People> findAllPeople();
}