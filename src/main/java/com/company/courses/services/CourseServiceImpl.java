package com.company.courses.services;

import com.company.courses.dao.CourseDao;
import com.company.courses.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseDao courseDao;

    @Override
    @SuppressWarnings("unchecked")
    public List<Course> findAllCourses() {
        return (List)courseDao.findAll();
    }

    @Override
    public Course findCourseById(Long courseId) {
        return courseDao.findOne(courseId);
    }

    @Override
    public void save(Course course, MultipartFile file) {
        try {
            course.setImage(file.getBytes());
            courseDao.save(course);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Override
    public void delete(Course course) {
        courseDao.delete(course);
    }
}
