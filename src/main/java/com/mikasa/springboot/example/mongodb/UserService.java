package com.mikasa.springboot.example.mongodb;

import com.mikasa.springboot.example.domain.MongoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sherlock on 16/9/22.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public MongoUser save(MongoUser mongoUser){
        userRepository.save(mongoUser);
        return mongoUser;
    }

    public List<MongoUser> findAll(){
        return userRepository.findAll();
    }

    public MongoUser findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
