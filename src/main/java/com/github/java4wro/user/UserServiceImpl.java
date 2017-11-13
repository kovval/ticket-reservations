package com.github.java4wro.user;

import com.github.java4wro.user.dto.UserDTO;
import com.github.java4wro.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO findUser(String userMail) {
        User user = userRepository.findOneByEmail(userMail);
        if(user==null){
            throw new RuntimeException();
        }
        return userMapper.toUserDTO(user);
    }

    @Override
    public void addUSer(UserDTO userDTO) {
        User user=new User();
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());

        userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> userList=userRepository.findAll();
        return userMapper.toUserDTO(userList);
    }

}
