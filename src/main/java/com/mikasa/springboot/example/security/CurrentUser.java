package com.mikasa.springboot.example.security;

import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by sherlock on 16/10/10.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }
}
