package com.company.courses.model;

import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EvaluationTest {

    private Evaluation evaluation;

    @Before
    public void setUp() throws Exception {
        evaluation = new Evaluation();
    }

    @After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getId() throws Exception {
        evaluation.setId(1L);
        Assert.assertEquals((Long)1L, evaluation.getId());
    }

    @Test
    public void setId() throws Exception {
        evaluation.setId(1L);
        Assert.assertEquals((Long)1L, evaluation.getId());
    }

    @Test
    public void getQuestions() throws Exception {
        Question question1 = new Question();
        Question question2 = new Question();
        List<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        evaluation.setQuestions(questions);

        Assert.assertEquals(questions, evaluation.getQuestions());
    }

    @Test
    public void setQuestions() throws Exception {
        Question question1 = new Question();
        Question question2 = new Question();
        List<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        evaluation.setQuestions(questions);

        Assert.assertEquals(questions, evaluation.getQuestions());
    }

    @Test
    public void addQuestion() throws Exception {
        Question question = new Question();
        evaluation.addQuestion(question);

        Assert.assertEquals(question, evaluation.getQuestions().get(0));
    }

    @Test
    public void getCourse() throws Exception {
        Course course = new Course();
        course.setName("Random Name");
        course.setDescription("Random Description");
        evaluation.setCourse(course);

        Assert.assertEquals(course, evaluation.getCourse());
    }

    @Test
    public void setCourse() throws Exception {
        Course course = new Course();
        course.setName("Random Name");
        course.setDescription("Random Description");
        evaluation.setCourse(course);

        Assert.assertEquals(course, evaluation.getCourse());
    }

}