package com.mikasa.springboot.example.security;

import com.mikasa.springboot.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by sherlock on 2016/11/2.
 */

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDao userDao;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().and()
                .logout().and()
                .authorizeRequests()
                .anyRequest().fullyAuthenticated().and()
                .csrf().disable();

    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    public MyAuthenticationProvider authenticationProvider()  throws Exception {
        MyAuthenticationProvider authenticationProvider = new MyAuthenticationProvider(userDao);
        return authenticationProvider;
    }
}
