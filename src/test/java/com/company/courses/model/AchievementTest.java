package com.company.courses.model;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class AchievementTest {

    private Achievement achievement;

    @Before
    public void setUp() throws Exception {
        achievement = new Achievement();
    }

    @After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getId() throws Exception {
        achievement.setId(1L);
        Assert.assertEquals((Long)1L, achievement.getId());
    }

    @Test
    public void setId() throws Exception {
        achievement.setId(1L);
        Assert.assertEquals((Long)1L, achievement.getId());
    }

    @Test
    public void getName() throws Exception {
        achievement.setName("Random Name");
        Assert.assertEquals("Random Name", achievement.getName());
    }

    @Test
    public void setName() throws Exception {
        achievement.setName("Random Name");
        Assert.assertEquals("Random Name", achievement.getName());
    }

    @Test
    public void getDescription() throws Exception {
        achievement.setDescription("Random Description");
        Assert.assertEquals("Random Description", achievement.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        achievement.setDescription("Random Description");
        Assert.assertEquals("Random Description", achievement.getDescription());
    }

    @Test
    public void getBadge() throws Exception {
        byte[] var = new byte[100];
        for(byte i = 0;i < 100;i++){
            var[i] = i;
        }
        achievement.setBadge(var);
        Assert.assertEquals(var, achievement.getBadge());
    }

    @Test
    public void setBadge() throws Exception {
        byte[] var = new byte[100];
        for(byte i = 0;i < 100;i++){
            var[i] = i;
        }
        achievement.setBadge(var);
        Assert.assertEquals(var, achievement.getBadge());
    }

    @Test
    public void getPoints() throws Exception {
        achievement.setPoints(100);
        Assert.assertEquals((Integer)100, achievement.getPoints());
    }

    @Test
    public void setPoints() throws Exception {
        achievement.setPoints(100);
        Assert.assertEquals((Integer)100, achievement.getPoints());
    }

    @Test
    public void getSubject() throws Exception {
        Subject subject = new Subject();
        subject.setName("Random Name");
        subject.setDescription("Random Description");
        achievement.setSubject(subject);
        Assert.assertEquals(subject, achievement.getSubject());
    }

    @Test
    public void setSubject() throws Exception {
        Subject subject = new Subject();
        subject.setName("Random Name");
        subject.setDescription("Random Description");
        achievement.setSubject(subject);
        Assert.assertEquals(subject, achievement.getSubject());
    }

    @Test
    public void getCourse() throws Exception{
        Course course = new Course();
        course.setName("Random Name");
        course.setDescription("Random Description");
        course.setDifficulty("Random Difficulty");

        achievement.setCourse(course);
        Assert.assertEquals(course, achievement.getCourse());
    }

}