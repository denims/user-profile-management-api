package com.deni.web.controller;

import com.deni.web.domain.User;
import com.deni.web.dto.UserDTO;
import com.deni.web.mapper.UserMapper;
import com.deni.web.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/user/save")
    public void saveNewUser(@RequestBody UserDTO user) {
        userService.saveUser(userMapper.userDtoToUser(user));
    }

    @GetMapping("/user/{userName}/get")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
        return ResponseEntity.ok(userService.getUserByName(userName));
    }
}
