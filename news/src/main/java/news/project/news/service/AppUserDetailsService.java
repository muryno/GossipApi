package news.project.news.service;

import news.project.news.model.User;
import news.project.news.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The email %s doesn't exist", email));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getEmail(), user.getPassword(), authorities);

        return userDetails;
    }

}
