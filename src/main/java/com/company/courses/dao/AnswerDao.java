package com.company.courses.dao;

import com.company.courses.model.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerDao extends CrudRepository<Answer, Long>{
    @Query("select a from Answer a")
    List<Answer> findAll();
}
