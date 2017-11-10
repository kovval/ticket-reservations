package com.github.java4wro.user;

import com.github.java4wro.user.dto.UserDTO;


public interface UserService {

    UserDTO findUser(String userEmail);
}
