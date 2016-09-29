package com.mikasa.springboot.example.elasticsearch;

import com.mikasa.springboot.example.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by sherlock on 16/9/21.
 */
public interface PostRepository extends ElasticsearchRepository<Post, String> {

    Page<Post> findByTagsName(String name, Pageable pageable);

    List<Post> findByRatingBetween(Double beginning, Double end);

}
