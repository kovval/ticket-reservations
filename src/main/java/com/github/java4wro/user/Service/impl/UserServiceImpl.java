package com.github.java4wro.user.Service.impl;

import com.github.java4wro.user.Service.UserService;
import com.github.java4wro.user.UserMapper;
import com.github.java4wro.user.UserRepository;
import com.github.java4wro.user.dto.UserDTO;
import com.github.java4wro.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 10.11.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO findUser(String userMail) {
        User user = userRepository.findOneByEmail(userMail);
        if(user==null){
            throw new RuntimeException();
        }
        return userMapper.toUserDTO(user);
    }
}
