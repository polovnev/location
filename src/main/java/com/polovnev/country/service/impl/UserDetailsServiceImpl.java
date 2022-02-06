package com.polovnev.country.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final Map<String, UserDetails> users = new HashMap<>();

    @PostConstruct
    private void initUsers() {
        GrantedAuthority userGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        GrantedAuthority adminGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        users.put("user", new User("user",
                "pass", Collections.singletonList(userGrantedAuthority)));
        users.put("admin", new User("admin",
                "pass", Collections.singletonList(adminGrantedAuthority)));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.get(username);
    }
}
