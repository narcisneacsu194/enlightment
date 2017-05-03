package com.company.courses.dao;

import com.company.courses.model.Achievement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementDao extends CrudRepository<Achievement, Long>{
    @Query("select a from Achievement a")
    List<Achievement> findAll();
}
