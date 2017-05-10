package com.company.courses.services;


import com.company.courses.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
    UserDetails loadUserByUsername(String username);
    User findByUsername(String username);
    User registerNewUser(String username, boolean enabled, String password);
    void save(User user);
    List<User> findAll();
}
