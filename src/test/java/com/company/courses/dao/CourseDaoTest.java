package com.company.courses.dao;

import com.company.courses.model.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

@RunWith(value = SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "spring.datasource.url = jdbc:h2:./database/test-CourseDaoTest-courses;DB_CLOSE_ON_EXIT=FALSE")
public class CourseDaoTest {
    @Autowired
    private CourseDao courseDao;

    @Test
    public void findAll_ShouldReturnAllCourses() throws Exception{
        Assert.assertThat(courseDao.findAll(), hasSize(1));
    }

    @Test
    public void findOne_ShouldReturnNull() throws Exception{
        Assert.assertThat(courseDao.findOne(10L), nullValue(Course.class));
    }

    @Test
    public void findOne_ShouldFindOneCourse() throws Exception{
        Assert.assertThat(courseDao.findOne(1L), notNullValue(Course.class));
    }

    @Test
    public void save_ShouldSaveCourseIntoDatabase() throws Exception{
        Course course = new Course();
        courseDao.save(course);
        Course course2 = courseDao.findOne(course.getId());

        Assert.assertThat(courseDao.findOne(course.getId()), notNullValue(Course.class));
        Assert.assertThat(courseDao.findAll(), hasSize(2));

        courseDao.delete(course);
    }

    @Test
    public void save_ShouldSaveCourseListIntoDatabase() throws Exception{
        Course course1 = new Course();
        Course course2 = new Course();

        List<Course> courses = new ArrayList<>();
        courses.add(course1);courses.add(course2);

        courseDao.save(courses);

        Assert.assertThat(courseDao.findAll(), hasSize(3));
        Assert.assertThat(courseDao.findOne(course1.getId()), notNullValue());
        Assert.assertThat(courseDao.findOne(course2.getId()), notNullValue());

        courseDao.delete(course1);
        courseDao.delete(course2);
    }

    @Test
    public void delete_ShouldDeleteCourseFromDatabase() throws Exception{
        Course course = new Course();
        courseDao.save(course);

        Assert.assertThat(courseDao.findOne(course.getId()),
                notNullValue(Course.class));

        Long courseId = course.getId();
        courseDao.delete(course);

        Assert.assertThat(courseDao.findOne(courseId),
                nullValue(Course.class));
    }

    @Test
    public void delete_ShouldDeleteCourseByIdFromDatabase() throws Exception{
        Course course = new Course();
        courseDao.save(course);

        Assert.assertThat(courseDao.findOne(course.getId()),
                notNullValue(Course.class));

        Long courseId = course.getId();
        courseDao.delete(course.getId());

        Assert.assertThat(courseDao.findOne(courseId),
                nullValue(Course.class));

    }

    @Test
    public void delete_ShouldDeleteCourseListFromDatabase() throws Exception{
        Course course1 = new Course();
        Course course2 = new Course();

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courseDao.save(courses);

        Assert.assertThat(courseDao.findAll(), hasSize(3));

        courseDao.delete(courses);

        Assert.assertThat(courseDao.findAll(), hasSize(1));
    }

    @Test
    public void exists_ShouldReturnTrue() throws Exception{
        Assert.assertEquals(true, courseDao.exists(1L));
    }

    @Test
    public void exists_ShouldReturnFalse() throws Exception{
        Assert.assertEquals(false, courseDao.exists(2L));
    }

}