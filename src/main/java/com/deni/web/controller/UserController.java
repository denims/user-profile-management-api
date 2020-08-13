package com.deni.web.controller;

import com.deni.web.domain.User;
import com.deni.web.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/save")
    public void saveNewUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/user/{userName}/get")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
        return ResponseEntity.ok(userService.getUserByName(userName));
    }
}
