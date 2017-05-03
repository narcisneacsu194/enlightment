package com.company.courses.dao;

import com.company.courses.model.Degree;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DegreeDao extends CrudRepository<Degree, Long>{
    @Query("select d from Degree d")
    List<Degree> findAll();
}
