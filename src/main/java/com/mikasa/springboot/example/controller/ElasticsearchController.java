package com.mikasa.springboot.example.controller;

import com.mikasa.springboot.example.domain.Post;
import com.mikasa.springboot.example.domain.Tag;
import com.mikasa.springboot.example.elasticsearch.PostService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by sherlock on 16/9/21.
 */

@RestController
@RequestMapping("/elasticsearch")
public class ElasticsearchController {

    Logger log = LoggerFactory.getLogger(ElasticsearchController.class);

    @Autowired
    private PostService postService;

    @ApiOperation(value="测试保存elasticsearch", notes="elasticsearch保存Post")
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public Object save() {
        log.info("测试elasticsearch...");
        Tag tag = new Tag();
        tag.setId("3");
        tag.setName("lol");
        Tag tag2 = new Tag();
        tag2.setId("4");
        tag2.setName("java");

        Post post = new Post();
        post.setId("2");
        post.setTitle("test_elasticsearch");
        post.setRating(9.9);
        post.setTags(Arrays.asList(tag, tag2));
        postService.save(post);
        return post;
    }

    @ApiOperation(value="测试获取elasticsearch", notes="elasticsearch获取list")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object list() {
        log.info("测试获取elasticsearch...");
        Iterable<Post> iterable = postService.findAll();
        return iterable;
    }

    @ApiOperation(value="通过id获取post", notes="elasticsearch通过id获取post")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "String")
    @RequestMapping(value = "/find{id}",method = RequestMethod.GET)
    public Object find(@PathVariable String id) {
        log.info("测试获取elasticsearch...ById");
        Post post = postService.findOne(id);
        return post;
    }
}
