package com.mikasa.springboot.example.security;

import com.mikasa.springboot.example.dao.UserDao;
import com.mikasa.springboot.example.domain.User;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sherlock on 2016/11/2.
 */

public class MyAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private UserDao userDao;

    public MyAuthenticationProvider(UserDao userDao){
        this.userDao = userDao;

    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String username = String.valueOf(auth.getPrincipal());
        String password = String.valueOf(auth.getCredentials());

        User user = userDao.findByName(username);
        if(null != user){
            System.out.println(user.toString());
            // 验证密码.
            if (!user.getPassword().equals(password)) {
                throw new BadCredentialsException("密码错误");
            }else {
                // 3. 清空密码
                user.setPassword("");
            }
        }else {
            throw new AuthenticationCredentialsNotFoundException("账户不存在");
        }
        // 4. Return an authenticated token, containing user data and authorities
        return new UsernamePasswordAuthenticationToken(user.getUsername(), null, getAuthorities(user));
    }

    private Set<GrantedAuthority> getAuthorities(User user){
        //可以添加用户权限
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        return authorities;
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
