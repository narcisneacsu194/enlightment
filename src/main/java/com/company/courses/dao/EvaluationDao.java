package com.company.courses.dao;

import com.company.courses.model.Evaluation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationDao extends CrudRepository<Evaluation, Long>{
    @Query("select e from Evaluation e")
    List<Evaluation> findAll();
}
