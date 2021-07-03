package com.muryno.demo.controller;

import com.muryno.demo.model.Tweet;
import com.muryno.demo.model.Users;
import com.muryno.demo.repository.TweetRepository;
import com.muryno.demo.repository.UserRepository;
import com.muryno.demo.services.TweetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "api/v1/amebo/tweet/")
public class TweetController {


 private  final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }






    @PostMapping
    public ResponseEntity<?>  postGist(@RequestBody Tweet tweet, @RequestParam Long id){
        return  tweetService.CreateTask(tweet,id);
    }





}
