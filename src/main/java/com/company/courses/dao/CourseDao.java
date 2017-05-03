package com.company.courses.dao;

import com.company.courses.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao extends CrudRepository<Course, Long>{
    @Query("select c from Course c")
    List<Course> findAll();
}
