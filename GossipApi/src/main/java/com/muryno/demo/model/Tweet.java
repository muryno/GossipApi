package com.muryno.demo.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tweets")
public class Tweet {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "posts")
    private String Posts;

    @Column(name = "lastName")
    private  String Lastname;

    //unidirectional one on one mapping
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Users users;


}
