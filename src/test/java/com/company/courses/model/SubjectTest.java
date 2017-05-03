package com.company.courses.model;

import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SubjectTest {

    private Subject subject;

    @Before
    public void setUp() throws Exception {
        subject = new Subject();
    }

    @After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getId() throws Exception {
        subject.setId(1L);
        Assert.assertEquals((Long)1L, subject.getId());
    }

    @Test
    public void setId() throws Exception {
        subject.setId(1L);
        Assert.assertEquals((Long)1L, subject.getId());
    }

    @Test
    public void getName() throws Exception {
        subject.setName("Random Name");
        Assert.assertEquals("Random Name", subject.getName());
    }

    @Test
    public void setName() throws Exception {
        subject.setName("Random Name");
        Assert.assertEquals("Random Name", subject.getName());
    }

    @Test
    public void getDescription() throws Exception {
        subject.setDescription("Random Description");
        Assert.assertEquals("Random Description", subject.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        subject.setDescription("Random Description");
        Assert.assertEquals("Random Description", subject.getDescription());
    }

    @Test
    public void getImage() throws Exception {
        byte[] var = new byte[100];
        for(byte i = 0;i < 100;i++){
            var[i] = i;
        }

        subject.setImage(var);

        Assert.assertEquals(var, subject.getImage());
    }

    @Test
    public void setImage() throws Exception {
        byte[] var = new byte[100];
        for(byte i = 0;i < 100;i++){
            var[i] = i;
        }

        subject.setImage(var);

        Assert.assertEquals(var, subject.getImage());
    }

    @Test
    public void getAchievements() throws Exception {
        Achievement achievement1 = new Achievement();
        Achievement achievement2 = new Achievement();

        List<Achievement> achievements = new ArrayList<>();
        achievements.add(achievement1);
        achievements.add(achievement2);

        subject.setAchievements(achievements);

        Assert.assertEquals(achievements, subject.getAchievements());
    }

    @Test
    public void setAchievements() throws Exception {
        Achievement achievement1 = new Achievement();
        Achievement achievement2 = new Achievement();

        List<Achievement> achievements = new ArrayList<>();
        achievements.add(achievement1);
        achievements.add(achievement2);

        subject.setAchievements(achievements);

        Assert.assertEquals(achievements, subject.getAchievements());
    }

    @Test
    public void addAchievement() throws Exception {
        Achievement achievement = new Achievement();
        subject.addAchievement(achievement);

        Assert.assertEquals(achievement, subject.getAchievements().get(0));
    }

    @Test
    public void getDegrees() throws Exception {
        Degree degree1 = new Degree();
        Degree degree2 = new Degree();

        List<Degree> degrees = new ArrayList<>();
        degrees.add(degree1);
        degrees.add(degree2);

        subject.setDegrees(degrees);

        Assert.assertEquals(degrees, subject.getDegrees());
    }

    @Test
    public void setDegrees() throws Exception {
        Degree degree1 = new Degree();
        Degree degree2 = new Degree();

        List<Degree> degrees = new ArrayList<>();
        degrees.add(degree1);
        degrees.add(degree2);

        subject.setDegrees(degrees);

        Assert.assertEquals(degrees, subject.getDegrees());
    }

    @Test
    public void addDegree() throws Exception {
        Degree degree = new Degree();
        subject.addDegree(degree);

        Assert.assertEquals(degree, subject.getDegrees().get(0));
    }

    @Test
    public void getCourses() throws Exception {
        Course course1 = new Course();
        Course course2 = new Course();

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        subject.setCourses(courses);

        Assert.assertEquals(courses, subject.getCourses());
    }

    @Test
    public void setCourses() throws Exception {
        Course course1 = new Course();
        Course course2 = new Course();

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        subject.setCourses(courses);

        Assert.assertEquals(courses, subject.getCourses());
    }

    @Test
    public void addCourse() throws Exception {
        Course course = new Course();
        subject.addCourse(course);

        Assert.assertEquals(course, subject.getCourses().get(0));
    }

}