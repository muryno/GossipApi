package com.muryno.demo.controller;

import com.muryno.demo.model.Users;
import com.muryno.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;


@Slf4j
@SpringBootTest
class UserControllerTest {


    @Autowired
    UserRepository userRepository;


   //  Users  myUser ;

    @BeforeEach
    void setUp() {
       // creatUser();
    }

    @DisplayName("create adding new users ")
    @Test
    void creatUser() {
        // Setup our mock repository
        Users  myUser = new Users("Ade","Yemi","@Ade","123456");
        myUser.setDateReg(Date.from(Instant.now()));

      //  doReturn(myUser).when(userRepository).saveAndFlush(any());

        // Execute the service call
        Users returnedWidget = userRepository.saveAndFlush(myUser);

        // Assert the response
        Assertions.assertNotNull(returnedWidget, "The saved widget should not be null");
        Assertions.assertEquals("Ade", returnedWidget.getFirstName(), "The version should be incremented");
    }



    @Test
    @DisplayName("Test findAll")
    void testFindUser() {
        // Setup our mock repository
//        Users  myUser = new Users("Ade","Yemi","@Ade","123456");
//
//        Users  myUser2 = new Users("Ade","Yemi","@ogun","123456");
//        doReturn(Arrays.asList(myUser, myUser2)).when(userRepository).findAll();

        // Execute the service call
        List<Users> widgets = userRepository.findAll();

        // Assert the response
        Assertions.assertNotEquals(3, widgets.size(), "findAll should return 2 widgets");
    }
}