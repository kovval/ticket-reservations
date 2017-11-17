package com.github.java4wro.user;

import com.github.java4wro.user.dto.UserDTO;


import java.util.List;

public interface UserService {

    UserDTO findUserByEmail(String userEmail);

    UserDTO addUser(UserDTO userDTO);

    List<UserDTO> getAll();

    void confirmRegistration(String token);

    void sendEmailWhenForgotPassword(String email, String newPassword, String confirmNewPassword);

    void changePasswordsWhenForgot (String token);

}
