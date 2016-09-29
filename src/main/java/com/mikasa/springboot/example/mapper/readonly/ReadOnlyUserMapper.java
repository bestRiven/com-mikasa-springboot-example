package com.mikasa.springboot.example.mapper.readonly;

import com.mikasa.springboot.example.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by sherlock on 16/9/6.
 */

@Mapper
public interface ReadOnlyUserMapper {

    //@Select("SELECT id,name,phone FROM T_USER")
    List<User> findList();

    //@Select("SELECT id,name,phone FROM T_USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

}
