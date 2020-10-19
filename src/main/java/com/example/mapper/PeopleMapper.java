package com.example.mapper;

import com.example.entity.People;
import org.apache.ibatis.annotations.Insert;
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

    List<People> findAllPeople();

    @Select("select * from mydb.people where id = #{id}")
    @Results({
            @Result(property = "createTime", column = "create_time")
    })
    People findById(Integer id);

    @Insert(" <script>" +
            " insert into mydb.people " +
            " (name, create_time) " +
            " values" +
            " <foreach collection='list' item='item' separator=','>" +
            "  (#{item.name,jdbcType=VARCHAR}, #{item.createTime,jdbcType=TIMESTAMP})" +
            " </foreach>" +
            "</script>")
    int insert2(List<People> people);

}