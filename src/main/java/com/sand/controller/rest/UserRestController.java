package com.sand.controller.rest;

import com.sand.entity.User;
import com.sand.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
