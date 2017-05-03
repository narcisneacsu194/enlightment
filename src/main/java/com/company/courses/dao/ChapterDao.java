package com.company.courses.dao;

import com.company.courses.model.Chapter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterDao extends CrudRepository<Chapter, Long>{
    @Query("select c from Chapter c")
    List<Chapter> findAll();
}
