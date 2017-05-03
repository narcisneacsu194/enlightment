package com.company.courses.model;

import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CourseTest {

    private Course course;

    @Before
    public void setUp() throws Exception {
        course = new Course();
    }

    @After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getId() throws Exception {
        course.setId(1L);
        Assert.assertEquals((Long)1L, course.getId());
    }

    @Test
    public void setId() throws Exception {
        course.setId(1L);
        Assert.assertEquals((Long)1L, course.getId());
    }

    @Test
    public void getName() throws Exception {
        course.setName("Random Name");
        Assert.assertEquals("Random Name", course.getName());
    }

    @Test
    public void setName() throws Exception {
        course.setName("Random Name");
        Assert.assertEquals("Random Name", course.getName());
    }

    @Test
    public void getDescription() throws Exception {
        course.setDescription("Random Description");
        Assert.assertEquals("Random Description", course.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        course.setDescription("Random Description");
        Assert.assertEquals("Random Description", course.getDescription());
    }

    @Test
    public void getImage() throws Exception {
        byte[] var = new byte[100];
        for(byte i = 0;i < 100;i++){
            var[i] = i;
        }

        course.setImage(var);

        Assert.assertEquals(var, course.getImage());
    }

    @Test
    public void setImage() throws Exception {
        byte[] var = new byte[100];
        for(byte i = 0;i < 100;i++){
            var[i] = i;
        }

        course.setImage(var);

        Assert.assertEquals(var, course.getImage());
    }

    @Test
    public void getAchievements() throws Exception {
        Achievement achievement1 = new Achievement();
        Achievement achievement2 = new Achievement();

        List<Achievement> achievements = new ArrayList<>();
        achievements.add(achievement1);
        achievements.add(achievement2);

        course.setAchievements(achievements);

        Assert.assertEquals(achievements, course.getAchievements());
    }

    @Test
    public void setAchievements() throws Exception {
        Achievement achievement1 = new Achievement();
        Achievement achievement2 = new Achievement();

        List<Achievement> achievements = new ArrayList<>();
        achievements.add(achievement1);
        achievements.add(achievement2);

        course.setAchievements(achievements);

        Assert.assertEquals(achievements, course.getAchievements());
    }

    @Test
    public void addAchievement() throws Exception {
        Achievement achievement = new Achievement();

        course.addAchievement(achievement);

        Assert.assertEquals(achievement, course.getAchievements().get(0));
    }

    @Test
    public void getChapters() throws Exception {
        Chapter chapter1 = new Chapter();
        Chapter chapter2 = new Chapter();

        List<Chapter> chapters = new ArrayList<>();

        course.setChapters(chapters);

        Assert.assertEquals(chapters, course.getChapters());
    }

    @Test
    public void setChapters() throws Exception {
        Chapter chapter1 = new Chapter();
        Chapter chapter2 = new Chapter();

        List<Chapter> chapters = new ArrayList<>();

        course.setChapters(chapters);

        Assert.assertEquals(chapters, course.getChapters());
    }

    @Test
    public void addChapter() throws Exception {
        Chapter chapter = new Chapter();

        course.addChapter(chapter);

        Assert.assertEquals(chapter, course.getChapters().get(0));
    }

    @Test
    public void getEvaluations() throws Exception {
        Evaluation evaluation1 = new Evaluation();
        Evaluation evaluation2 = new Evaluation();
        List<Evaluation> evaluations = new ArrayList<>();
        evaluations.add(evaluation1);
        evaluations.add(evaluation2);
        course.setEvaluations(evaluations);
        Assert.assertEquals(evaluations, course.getEvaluations());
    }

    @Test
    public void setEvaluations() throws Exception {
        Evaluation evaluation1 = new Evaluation();
        Evaluation evaluation2 = new Evaluation();
        List<Evaluation> evaluations = new ArrayList<>();
        evaluations.add(evaluation1);
        evaluations.add(evaluation2);
        course.setEvaluations(evaluations);
        Assert.assertEquals(evaluations, course.getEvaluations());
    }

    @Test
    public void addEvaluation() throws Exception {
        Evaluation evaluation = new Evaluation();
        course.addEvaluation(evaluation);
        Assert.assertEquals(evaluation, course.getEvaluations().get(0));
    }

    @Test
    public void getSubject() throws Exception {
        Subject subject = new Subject();
        subject.setName("Random Name");
        subject.setDescription("Random Description");
        course.setSubject(subject);
        Assert.assertEquals(subject, course.getSubject());
    }

    @Test
    public void setSubject() throws Exception {
        Subject subject = new Subject();
        subject.setName("Random Name");
        subject.setDescription("Random Description");
        course.setSubject(subject);
        Assert.assertEquals(subject, course.getSubject());
    }

    @Test
    public void getDifficulty() throws Exception {
        course.setDifficulty("easy");
        Assert.assertEquals("easy", course.getDifficulty());
    }

    @Test
    public void setDifficulty() throws Exception {
        course.setDifficulty("easy");
        Assert.assertEquals("easy", course.getDifficulty());
    }

}