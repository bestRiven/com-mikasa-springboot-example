package com.mikasa.springboot.example.service;

import com.mikasa.springboot.example.domain.User;

import java.util.List;

/**
 * Created by sherlock on 16/9/6.
 */
public interface UserService {

    List<User> findAll();

    int insert(String username,String phone);

    int insertByUser(User user);

    void update(User user);

    void delete(int id);

    User findByName(String username);

    List<User> getUserList();

    List<User> findList();

}
