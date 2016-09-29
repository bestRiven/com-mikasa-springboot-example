package com.mikasa.springboot.example.controller;

import com.mikasa.springboot.example.domain.MongoUser;
import com.mikasa.springboot.example.mongodb.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sherlock on 16/9/22.
 */


@RestController
@RequestMapping("/mongo")
public class MongoController {

    Logger log = LoggerFactory.getLogger(ElasticsearchController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value="测试保存mongo", notes="mongo保存user")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Object save() {
        log.info("测试mongo...");
        MongoUser mongoUser = new MongoUser(1l,"Sherlock",23);
        return userService.save(mongoUser);
    }

    @ApiOperation(value="测试获取mongo", notes="mongo获取list")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object list() {
        log.info("测试获取mongo...");
        List<MongoUser> list = userService.findAll();
        return list;
    }

    @ApiOperation(value="通过name获取user", notes="mongo通过username获取user")
    @ApiImplicitParam(name = "name", value = "用户名", required = true, paramType = "path", dataType = "String")
    @RequestMapping(value = "/find{name}",method = RequestMethod.GET)
    public Object find(@PathVariable String name) {
        log.info("测试获取mongo...ByUsername");
        MongoUser user = userService.findByUsername(name);
        return user;
    }
}
