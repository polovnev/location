package com.polovnev.country.service.impl;

import com.polovnev.country.entity.CustomUserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new User("username", "pass", new ArrayList<>()
                /*Stream.of("USER", "ADMIN").collect(Collectors.toList())*/);
    }
}
