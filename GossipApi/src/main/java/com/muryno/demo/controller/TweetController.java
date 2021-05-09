package com.muryno.demo.controller;

import com.muryno.demo.model.Tweet;
import com.muryno.demo.model.Users;
import com.muryno.demo.repository.TweetRepository;
import com.muryno.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "api/v1/task")
public class TweetController {


    private final TweetRepository taskRepository;

    public TweetController(TweetRepository userRepository) {
        this.taskRepository = userRepository;
    }




//
//    @PostMapping
//    @RequestMapping(value = "/")
//    public Tweet creatSession(@RequestBody Tweet tweet){
//        return   taskRepository.saveAndFlush(tweet);
//    }



}
