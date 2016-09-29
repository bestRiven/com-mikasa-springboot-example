package com.mikasa.springboot.example.service.impl;

import com.mikasa.springboot.example.dao.UserDao;
import com.mikasa.springboot.example.domain.User;
import com.mikasa.springboot.example.redis.RedisUtil;
import com.mikasa.springboot.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sherlock on 16/9/6.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public int insert(String name, String phone) {
        return userDao.insert(name,phone);
    }

    @Override
    public int insertByUser(User user) {
        return userDao.insertByUser(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    @Cacheable(value = "findUserByNameCache", keyGenerator = "wiselyKeyGenerator")
    public User findByName(String name) {
        User user = (User) redisUtil.get(name);
        if(user == null){
            System.out.println("无缓存的时候调用这里");
            user = userDao.findByName(name);
            redisUtil.set(name,user);
        }
        return user;
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public List<User> findList() {
        return userDao.findList();
    }
}
