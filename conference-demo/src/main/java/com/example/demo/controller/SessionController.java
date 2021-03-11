package com.example.demo.controller;


import com.example.demo.model.Session;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/api/v1/session/")
public class SessionController {

    @Autowired
    public SessionRepository sessionRepository;

    @GetMapping
    public List<Session>  getAllSession(){
        return  sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session findById(@PathVariable Long id){
        return  sessionRepository.getOne(id);
    }

    @PostMapping
    @RequestMapping(value = "add")
    public  Session creatSession(@RequestBody Session session){
      return   sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable Long id){
        sessionRepository.deleteById(id);
    }

    //patch update part
    //put update all
    @RequestMapping(value = "update/{id}",method = RequestMethod.PATCH)
    public Session updateRecord(@PathVariable Long id,@RequestBody Session session){

        Session getExisting =  sessionRepository.getOne(id);
        BeanUtils.copyProperties(session,getExisting,"session_id");
        return sessionRepository.saveAndFlush(getExisting);
    }


}
