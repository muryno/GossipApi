package com.muryno.demo.services;

import com.muryno.demo.controller.BaseResponse;
import com.muryno.demo.model.Tweet;
import com.muryno.demo.model.Users;
import com.muryno.demo.repository.TweetRepository;
import com.muryno.demo.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TweetService {


    private final TweetRepository taskRepository;
    private final UserRepository userRepository;

    public TweetService(TweetRepository taskRepository,UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }


    public ResponseEntity<?> CreateTask(Tweet tweet,Long user_id){


        try {

           Optional<Users> user   =   userRepository.findById(user_id);

           if(user.isEmpty()){
               var result = new BaseResponse<>(null, false, "User Id is Invalid");
               return new ResponseEntity<>(result, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
           }



            tweet.setUsers(user.get());
            Tweet myRepo =  taskRepository.saveAndFlush(tweet);
            if(myRepo.getId() > 0){

                var result = new BaseResponse<>(myRepo, true, "Tweet Saved Successfully");

                return new ResponseEntity<>(result, HttpStatus.OK);
            }else{
                var result = new BaseResponse<>(null, false, "No data");

                return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){

            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }

    }

}
