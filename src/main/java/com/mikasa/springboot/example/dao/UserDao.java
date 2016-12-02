package com.mikasa.springboot.example.dao;

import com.mikasa.springboot.example.domain.User;
import com.mikasa.springboot.example.mapper.rds.MetaMapper;
import com.mikasa.springboot.example.mapper.rds.UserMapper;
import com.mikasa.springboot.example.mapper.readonly.ReadOnlyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sherlock on 16/9/12.
 */

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MetaMapper metaMapper;

    @Autowired
    private ReadOnlyUserMapper readOnlyUserMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User findById(Integer id){
        return userMapper.findById(id);
    }

    @Transactional
    public int insert(String username,String password, String phone) {
        return userMapper.insert(username,password,phone);
    }
    
    @Transactional
    public int insertByUser(User user) {
        return userMapper.insertByUser(user);
    }

    @Transactional
    public void update(User user) {
        userMapper.update(user);
    }

    @Transactional
    public void delete(int id) {
        userMapper.delete(id);
    }

    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    public List<User> getUserList() throws DataAccessException {
        return metaMapper.getUserList();
    }

    public List<User> findList() {
        return readOnlyUserMapper.findList();
    }

}
