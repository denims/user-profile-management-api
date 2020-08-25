package com.deni.web.service;

import com.deni.web.domain.User;
import com.deni.web.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User saveUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public User getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
