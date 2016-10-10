package com.mikasa.springboot.example.mapper.rds;

import com.mikasa.springboot.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by sherlock on 16/9/12.
 */

@Mapper
public interface MetaMapper {

    @SelectProvider(type = MetaSelectProvider.class, method = "getUserList")
    @Results(value ={
            @Result(id=true, property="id",column="id",javaType=Integer.class,jdbcType= JdbcType.INTEGER),
            @Result(property="username",column="username",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(property="phone",column="phone",javaType=String.class,jdbcType=JdbcType.VARCHAR)})
    List<User> getUserList();
}
