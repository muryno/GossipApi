package com.muryno.oauth.demooauth2.controller;



import com.muryno.oauth.demooauth2.model.users;
import com.muryno.oauth.demooauth2.repository.UserRepository;
import com.muryno.oauth.demooauth2.responds.BvnResponds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;


//    @Autowired
//    PasswordEncoder passwordEncoder;


    @PostMapping("/create")
    public BvnResponds CreateUsers(@RequestBody final users usr){

        try {

            users sre = new users();
            sre.setEmail(usr.getEmail());
            sre.setPasswords(usr.getPasswords());
            sre.setName(usr.getName());
            users res =  userRepository.save(sre);
            return new   BvnResponds(res.getId(),res.getEmail(),res.getName());


        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Author not created successfully", exc);
        }

    }

    @RequestMapping(value = "/update/password/{id}",method = RequestMethod.PUT)
    public BvnResponds updatePin(@PathVariable Long id ,@RequestBody final String password){

        try {
            users existingUsr = userRepository.getOne(id);

            if (existingUsr.getId() != 0) {
                users prs = new users();

                BeanUtils.copyProperties(existingUsr, prs ,"user_id");
                users res =   userRepository.saveAndFlush(existingUsr);
                return new   BvnResponds(res.getId(),res.getName(),res.getEmail());
            } throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT, "User with id  " + id +  " not found");


        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Author not created successfully", exc);
        }
    }



    @GetMapping()
    public List<users> getSession(){
        return userRepository.findAll();
    }

    public static final List<users> USRS = Arrays.asList();

    @GetMapping()
    @RequestMapping(path = "/{userID}")
    public users getUser(@PathVariable Integer userID){
 return USRS.stream().filter(
            it->  userID.equals(it.getId())
        ).findFirst()
                .orElseThrow(()-> new IllegalArgumentException("User with id "+ userID+ "  does  not exist"));
    }
}
