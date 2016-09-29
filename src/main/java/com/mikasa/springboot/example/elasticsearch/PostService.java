package com.mikasa.springboot.example.elasticsearch;

import com.mikasa.springboot.example.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sherlock on 16/9/21.
 */

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post save(Post post){
        postRepository.save(post);
        return post;
    }

    public Post findOne(String id) {
        return postRepository.findOne(id);
    }

    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    public Page<Post> findByTagsName(String tagName, PageRequest pageRequest) {
        return postRepository.findByTagsName(tagName, pageRequest);
    }

    List<Post> findByRatingBetween(Double beginning, Double end){
        return postRepository.findByRatingBetween(beginning,end);
    }
}
