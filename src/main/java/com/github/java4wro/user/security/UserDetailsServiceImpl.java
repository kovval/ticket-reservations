package com.github.java4wro.user.security;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.java4wro.user.model.User;
import com.github.java4wro.user.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email){

        User user = userRepository.findOneByEmail(email);

        return new UserDetailsImpl(user.getEmail(),user.getPassword());
    }
}