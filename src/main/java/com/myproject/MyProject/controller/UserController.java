package com.myproject.MyProject.controller;

import com.myproject.MyProject.models.User;
import com.myproject.MyProject.repository.UserRepository;
import com.myproject.MyProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") Integer id) throws Exception {
        return userService.findUserById(id);
    }

    @PutMapping("/users/{userid}")
    public User updateUser(@RequestBody User user, @PathVariable Integer userid) throws Exception {
        return userService.updateUser(user, userid);
    }

    @PutMapping("/users/{userId1}/{userId2}")
    public User followUser(@PathVariable Integer userId1, @PathVariable Integer userId2) throws Exception {
        return userService.followUser(userId1, userId2);
    }

    @GetMapping("/users/follow/{userId1}/{userId2}")
    public User followUserHandler(@PathVariable Integer userId1, @PathVariable Integer userId2) throws Exception {
        // continue from here.
        return userService.followUser(userId1, userId2);
    }

    @GetMapping("/users/search")
    public List<User> searchUser(@RequestParam("query") String query) {
        return userService.searchUser(query);
    }
}
