package com.muryno.demo.controller;

import com.muryno.demo.model.Users;
import com.muryno.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(name = "api/v1/user/")
public class UserController {


    private final UserRepository  userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }







    @PostMapping
    @RequestMapping(value = "add")
    public Users creatUser(@RequestBody Users user){
        return   userRepository.saveAndFlush(user);
    }



}
