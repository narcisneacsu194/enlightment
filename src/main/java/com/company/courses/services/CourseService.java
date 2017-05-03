package com.company.courses.services;


import com.company.courses.model.Course;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourses();
    Course findCourseById(Long courseId);
    void save(Course course, MultipartFile file);
    void delete(Course course);
}
