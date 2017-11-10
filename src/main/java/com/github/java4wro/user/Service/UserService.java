package com.github.java4wro.user.Service;

import com.github.java4wro.user.dto.UserDTO;

/**
 * Created by admin on 10.11.2017.
 */
public interface UserService {

    UserDTO findUser(String userUuid);
}
