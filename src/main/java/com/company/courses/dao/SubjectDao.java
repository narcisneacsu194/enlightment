package com.company.courses.dao;

import com.company.courses.model.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectDao extends CrudRepository<Subject, Long>{
    @Query("select s from Subject s")
    List<Subject> findAll();
}
