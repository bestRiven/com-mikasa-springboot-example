package com.mikasa.springboot.example.controller;

import com.mikasa.springboot.example.domain.MyException;
import com.mikasa.springboot.example.domain.User;
import com.mikasa.springboot.example.redis.RedisUtil;
import com.mikasa.springboot.example.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sherlock on 16/9/5.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    @Value("${com.user.name}")
    private String name;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Object test() {

        log.info(".   ____          _            __ _ _\n" +
                " /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\\n" +
                "( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\\n" +
                " \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )\n" +
                "  '  |____| .__|_| |_|_| |_\\__, | / / / /\n" +
                " =========|_|==============|___/=/_/_/_/");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name",name);
        map.put("result","success");
        return map;
    }

    @ApiOperation(value="获取用户列表", notes="获取全部的用户信息")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object list() {
        log.info("查询所有用户信息...");
        List<User> rds = userService.findAll();
        List<User> readonly = userService.findList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("rds",rds);
        map.put("readonly",readonly);
        return map;
    }

    @ApiOperation(value="获取用户列表", notes="获取全部的用户信息")
    @RequestMapping(value = "/userList",method = RequestMethod.GET)
    public Object userList() {
        log.info("查询所有用户信息...");
        List<User> list = userService.getUserList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("result",list);
        return map;
    }

    @ApiOperation(value="获取用户详情", notes="根据用户名获取用户详情")
    @ApiImplicitParam(name = "name", value = "用户名", required = true, paramType = "path", dataType = "String")
    @RequestMapping(value = "/find/{name}",method = RequestMethod.GET)
    public Object findByName(@PathVariable String name) {
        log.info("获取用户详情...");
        User user = userService.findByName(name);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("result",user);
        return map;
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public Object add(@RequestParam(value = "username") String username,@RequestParam(value = "phone") String phone) {
        log.info("添加用户...");
        User user = new User();
        user.setUsername(username);
        user.setPhone(phone);
        int result = userService.insert(username,phone);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("result",result);
        return map;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="insert", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        userService.insertByUser(user);
        return "success";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() throws Exception {
        throw new MyException("发生错误");
    }

    @ApiOperation(value="redis获取用户详情", notes="根据用户名获取用户详情")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "path", dataType = "String")
    @RequestMapping(value = "/find/redis/{username}",method = RequestMethod.GET)
    public Object findByNameForRedis(@PathVariable String username) {
        redisUtil.remove("tiffany");
        log.info("从redis中获取用户详情...");
        User user = userService.findByName(username);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("result",user);
        return map;
    }

    @ApiOperation(value="redis消息队列", notes="redis消息队列发送消息")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "path", dataType = "String")
    @RequestMapping(value = "/redis/send/{username}",method = RequestMethod.GET)
    public Object sendMessage(@PathVariable String username) {
        log.info("从redis中获取用户详情...");
        User user = userService.findByName(username);
        redisUtil.sendMessage("chat",user);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("result",user);
        return map;
    }

}
