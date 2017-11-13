package com.github.java4wro.user;

import com.github.java4wro.user.dto.UserDTO;
import com.github.java4wro.user.emailService.EmailSender;
import com.github.java4wro.user.exceptions.EmailExistException;
import com.github.java4wro.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZonedDateTime;
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
            throw new EmailExistException(userMail);
        }
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO addUser(UserDTO userDTO)  {

        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new EmailExistException(userDTO.getEmail());
        }

            User user = new User();
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setEmail(userDTO.getEmail());
            user.setEnabled(false);

            sendEmail(user.getEmail(), user.getUuid());

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
            Instant now = ZonedDateTime.now().minusDays(30).toInstant();
            Instant expiryDate = user.getCreatedAt().toInstant();
            user.setEnabled(true);
        }
        userRepository.save(user);
    }

    private void sendEmail (String to, String token){
        String content="http://localhost:8099//api/users/confirmRegistration/?token="+token;
        String subject="Confirm registration";

        emailSender.sendEmail(to,subject,content);
    }

}
