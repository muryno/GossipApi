package news.project.news.service;

import news.project.news.model.User;

import java.util.List;

public interface GenericService {
    User findByUsername(String email);

    List<User> findAllUsers();
}
