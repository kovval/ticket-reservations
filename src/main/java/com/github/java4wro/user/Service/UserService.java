package com.github.java4wro.user.Service;

import com.github.java4wro.user.dto.UserDTO;


public interface UserService {

    UserDTO findUser(String userEmail);
}
