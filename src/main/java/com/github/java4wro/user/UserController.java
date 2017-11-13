package com.github.java4wro.user;


import com.github.java4wro.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    List<UserDTO> getAll(){
        return userService.getAll();
    }

}
