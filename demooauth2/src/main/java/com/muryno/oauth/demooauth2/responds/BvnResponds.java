package com.muryno.oauth.demooauth2.responds;

public class BvnResponds {

    private Integer id;
    private String Email;
    private String Name;

    public BvnResponds(Integer id, String email, String name) {
        this.id = id;
        Email = email;
        Name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return Email;
    }

    public String getName() {
        return Name;
    }
}
