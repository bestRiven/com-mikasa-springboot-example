package com.mikasa.springboot.example.elasticsearch;

import com.mikasa.springboot.example.domain.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sherlock on 16/9/22.
 */
public interface PostCrudRepository extends CrudRepository<Post,String> {

    Post findByTitle(String title);
}
