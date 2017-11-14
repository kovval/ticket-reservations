package com.github.java4wro.user;

import com.github.java4wro.user.dto.UserDTO;
import com.github.java4wro.user.emailService.EmailSender;
import com.github.java4wro.user.exceptions.EmailExistException;
import com.github.java4wro.user.exceptions.EmailNotExistException;
import com.github.java4wro.user.exceptions.VerificationTimeExpiredException;
import com.github.java4wro.user.model.User;
import com.github.java4wro.user.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
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
            throw new EmailNotExistException(userMail);
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
        user.setRole(UserRole.USER);

        sendEmail(user.getEmail(), user.getUuid());
        System.out.println(user.getRole().name());

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
            Date now = new Date();
            Date expiryDate = user.getExpiryDate();

            if (expiryDate.compareTo(now)>0) user.setEnabled(true);
            else throw new VerificationTimeExpiredException(user.getEmail(),expiryDate);
        }

        userRepository.save(user);
    }

    private void sendEmail (String to, String token){
        String content="http://localhost:8099//api/users/confirmRegistration/?token="+token;
        String subject="Confirm registration";

        emailSender.sendEmail(to,subject,content);
    }

}
