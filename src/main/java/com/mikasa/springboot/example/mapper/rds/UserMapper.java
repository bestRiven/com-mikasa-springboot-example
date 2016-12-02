package com.mikasa.springboot.example.mapper.rds;

import com.mikasa.springboot.example.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by sherlock on 16/9/6.
 */

@Mapper
public interface UserMapper {

    @Select("SELECT id,username,password,phone FROM T_USER")
    List<User> findAll();

    @Select("SELECT id,username,password,phone FROM T_USER WHERE id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("SELECT id,username,password,phone FROM T_USER WHERE username = #{username}")
    User findByName(@Param("username") String username);

    @Insert("INSERT INTO T_USER(username,password,phone) VALUES(#{username},#{password},#{phone})")
    int insert(@Param("username") String username, @Param("password") String password, @Param("phone") String phone);

    @Insert("INSERT INTO T_USER(username,password,phone) VALUES(#{username},#{password},#{phone})")
    int insertByUser(User user);

    @Update("UPDATE T_USER SET name=#{username},phone=#{phone} WHERE id=#{id}")
    void update(User user);

    @Delete("DELETE FROM T_USER WHERE id =#{id}")
    void delete(int id);
}
