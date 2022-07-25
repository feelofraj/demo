package com.demo.services;

import java.util.ArrayList;

import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;

public class MyUserDetailsService implements UserDetailsService{
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("user","123",new ArrayList<>());
    }
}
