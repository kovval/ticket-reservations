package com.github.java4wro.user;


import com.github.java4wro.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;



    @GetMapping
            public void addUser(){
        User user=new User();
        user.setPassword("1");
        user.setEmail("2");

        userRepository.save(user);

    }





}
