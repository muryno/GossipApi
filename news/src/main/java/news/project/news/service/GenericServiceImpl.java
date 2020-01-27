package news.project.news.service;

import news.project.news.model.User;
import news.project.news.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GenericServiceImpl implements GenericService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

}
