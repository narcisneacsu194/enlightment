package com.company.courses.services;

import com.company.courses.dao.CourseDao;
import com.company.courses.model.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

    @Mock
    private CourseDao courseDao;

    @InjectMocks
    private CourseService service = new CourseServiceImpl();

    @Test
    public void findAllCourses() throws Exception {
        Course course1 = new Course();
        Course course2 = new Course();

        List<Course> courses = Arrays.asList(
                course1,
                course2
        );

        when(courseDao.findAll()).thenReturn(courses);

        Assert.assertEquals(2, service.findAllCourses().size());

        verify(courseDao).findAll();
    }

    @Test
    public void findCourseById() throws Exception {
        Course course = new Course();
        course.setName("Random Name");
        when(courseDao.findOne(1L)).thenReturn(
                course
        );

        Assert.assertEquals(course, service.findCourseById(1L));

        verify(courseDao).findOne(1L);
    }

}