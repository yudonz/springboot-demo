package com.example.demo.mapper;

import com.example.demo.entity.People;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author ZHAO Yudong
 * @Date 2020/8/5 13:39
 * @description：${description}
 */
public interface PeopleMapper extends Mapper<People> {
    int updateBatch(List<People> list);

    int batchInsert(@Param("list") List<People> list);

    List<People> findAllPeople();


    @Select("select * from mydb.people where id = #{id}")
    @Results({
            @Result(property = "createTime", column = "create_time")
    })
    People test(Integer id);


}