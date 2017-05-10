package com.company.courses.services;

import com.company.courses.dao.RoleDao;
import com.company.courses.dao.UserDao;
import com.company.courses.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@ComponentScan
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException{
        User user = userDao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(
                    username + " was not found"
            );
        }

        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        return user;
    }

    @Override
    public User registerNewUser(String username, boolean enabled, String password) {
        return userDao.save(new User(username, password, enabled));
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>)userDao.findAll();
    }
}
