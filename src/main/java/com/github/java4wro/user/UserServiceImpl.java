package com.github.java4wro.user;

import com.github.java4wro.user.dto.UserDTO;
import com.github.java4wro.user.emailService.EmailSender;
import com.github.java4wro.user.model.User;
import com.github.java4wro.user.security.SecurityAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailSender emailSender;

    @Override
    public UserDTO findUser(String userMail) {
        User user = userRepository.findOneByEmail(userMail);
        if(user==null){
            throw new RuntimeException();
        }
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO addUSer(UserDTO userDTO) {
        User user=new User();
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());

        sendEmail(user.getEmail(),user.getUuid());

        return userMapper.toUserDTO(userRepository.save(user));
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> userList=userRepository.findAll();
        return userMapper.toUserDTO(userList);
    }

    @Override
    public void confirmRegistration(String token) {
        User user=userRepository.findOneByUuid(token);

        if (user!=null){
            user.setEnabled(true);
        }
    }

    private void sendEmail (String to, String token){
        String content="http://localhost:8099//api/users/confirmRegistration?token="+token;
        String subject="Confirm registration";

        emailSender.sendEmail(to,subject,content);
    }

}
