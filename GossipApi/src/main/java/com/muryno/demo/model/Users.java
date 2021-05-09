package com.muryno.demo.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@RequiredArgsConstructor
@Table(name = "users")
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "firstName")
    private String FirstName;

    @NonNull
    @Column(name = "lastName")
    private  String Lastname;

    @NonNull
    @Column(name = "userName")
    private  String UserName;

    @NonNull
    @Column(name = "password")
    private String Password;


    @Column(name = "dateReg")
    private Date dateReg;


//    @OneToOne(mappedBy = "users")
//    private  Tweet tweet;


}
