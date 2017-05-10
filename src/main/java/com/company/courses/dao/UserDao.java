package com.company.courses.dao;

import com.company.courses.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface UserDao  extends CrudRepository<User, Long>{
    List<User> findAll();
    User findByUsername(String username);
}
