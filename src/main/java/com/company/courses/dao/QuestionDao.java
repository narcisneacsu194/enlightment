package com.company.courses.dao;

import com.company.courses.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends CrudRepository<Question, Long>{
    @Query("select q from Question q")
    List<Question> findAll();
}
