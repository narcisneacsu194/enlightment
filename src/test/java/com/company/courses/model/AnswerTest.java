package com.company.courses.model;

import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AnswerTest {
    private Answer answer;

    @Before
    public void setUp() throws Exception {
        answer = new Answer();
    }

    @After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getId() throws Exception {
        answer.setId(1L);
        Assert.assertEquals((Long)1L, answer.getId());
    }

    @Test
    public void setId() throws Exception {
        answer.setId(1L);
        Assert.assertEquals((Long)1L, answer.getId());
    }

    @Test
    public void getDescription() throws Exception {
        answer.setDescription("Random Description");
        Assert.assertEquals("Random Description", answer.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        answer.setDescription("Random Description");
        Assert.assertEquals("Random Description", answer.getDescription());
    }

    @Test
    public void getQuestions() throws Exception {
        Question question1 = new Question();
        question1.setDescription("Random Question 1 Description");
        Question question2 = new Question();
        question2.setDescription("Random Question 2 Description");
        List<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        answer.setQuestions(questions);
        Assert.assertEquals(questions, answer.getQuestions());
    }

    @Test
    public void setQuestions() throws Exception {
        Question question1 = new Question();
        question1.setDescription("Random Question 1 Description");
        Question question2 = new Question();
        question2.setDescription("Random Question 2 Description");
        List<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        answer.setQuestions(questions);
        Assert.assertEquals(questions, answer.getQuestions());
    }

    @Test
    public void addQuestion() throws Exception {
        Question question = new Question();
        question.setDescription("Random Question Description");
        answer.addQuestion(question);
        Assert.assertEquals("Random Question Description",
                answer.getQuestions().get(0).getDescription());
    }

}