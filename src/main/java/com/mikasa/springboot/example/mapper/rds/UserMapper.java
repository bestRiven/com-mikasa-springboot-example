package com.mikasa.springboot.example.mapper.rds;

import com.mikasa.springboot.example.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by sherlock on 16/9/6.
 */

@Mapper
public interface UserMapper {

    @Select("SELECT id,name,phone FROM T_USER")
    List<User> findAll();

    @Select("SELECT id,name,phone FROM T_USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO T_USER(NAME, PHONE) VALUES(#{name}, #{phone})")
    int insert(@Param("name") String name, @Param("phone") String phone);

    @Insert("INSERT INTO T_USER(NAME, PHONE) VALUES(#{name}, #{phone})")
    int insertByUser(User user);

    @Update("UPDATE T_USER SET name=#{name},age=#{age} WHERE id=#{id}")
    void update(User user);

    @Delete("DELETE FROM T_USER WHERE id =#{id}")
    void delete(int id);
}
