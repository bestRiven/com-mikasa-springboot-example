package com.mikasa.springboot.example.security;

import com.mikasa.springboot.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by sherlock on 16/10/10.
 */

@Component
public class CurrentUserDetailsService implements UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public CurrentUserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = new User();//userDao.findByName(email);
        user.setId(1l);
        user.setEmail("admin");
        user.setPassword("123456");
        user.setRole("ADMIN");
        return new CurrentUser(user);
    }
}
