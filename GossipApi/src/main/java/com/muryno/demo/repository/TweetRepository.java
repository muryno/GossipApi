package com.muryno.demo.repository;

import com.muryno.demo.model.Tweet;
import com.muryno.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet,Long > {
}
