package com.mikasa.springboot.example.mongodb;

import com.mikasa.springboot.example.domain.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by sherlock on 16/9/22.
 */
public interface UserRepository extends MongoRepository<MongoUser, Long> {

    MongoUser findByUsername(String username);

}
