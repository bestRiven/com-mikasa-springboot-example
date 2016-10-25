package com.mikasa.springboot.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        log.info("登录页面");
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        log.info("index页面");
        return "index";
    }
	
}
