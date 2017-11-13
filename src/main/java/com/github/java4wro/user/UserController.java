package com.github.java4wro.user;


import com.github.java4wro.user.dto.UserDTO;
import com.github.java4wro.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    List<UserDTO> getAll(){
        return userService.getAll();
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserDTO addUser (UserDTO userDto) {
        return userService.addUSer(userDto);
    }

}
