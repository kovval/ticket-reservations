package com.github.java4wro.user;


import com.github.java4wro.user.dto.UserDTO;
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
    @PostMapping(value = "/register")
    public UserDTO addUser (UserDTO userDto) {
        return userService.addUser(userDto);
    }

    @GetMapping(value = "/confirmRegistration")
    void confirmRegistration (@RequestParam("token") String token){
        userService.confirmRegistration(token);
    }

}
