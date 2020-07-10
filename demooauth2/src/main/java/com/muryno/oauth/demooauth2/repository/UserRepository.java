package com.muryno.oauth.demooauth2.repository;


import com.muryno.oauth.demooauth2.model.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<users,Long> {

}
