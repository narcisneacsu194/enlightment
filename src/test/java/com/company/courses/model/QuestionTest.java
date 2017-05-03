package com.company.courses.model;

import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionTest {

    private Question question;

    @Before
    public void setUp() throws Exception {
        question = new Question();
    }

    @After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getId() throws Exception {
        question.setId(1L);
        Assert.assertEquals((Long)1L, question.getId());
    }

    @Test
    public void setId() throws Exception {
        question.setId(1L);
        Assert.assertEquals((Long)1L, question.getId());
    }

    @Test
    public void getDescription() throws Exception {
        question.setDescription("Random Description");
        Assert.assertEquals("Random Description", question.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        question.setDescription("Random Description");
        Assert.assertEquals("Random Description", question.getDescription());
    }

    @Test
    public void getAnswers() throws Exception {
        Answer answer1 = new Answer();
        Answer answer2 = new Answer();

        List<Answer> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);

        question.setAnswers(answers);

        Assert.assertEquals(answers, question.getAnswers());
    }

    @Test
    public void setAnswers() throws Exception {
        Answer answer1 = new Answer();
        Answer answer2 = new Answer();

        List<Answer> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);

        question.setAnswers(answers);

        Assert.assertEquals(answers, question.getAnswers());
    }

    @Test
    public void addAnswer() throws Exception {
        Answer answer = new Answer();
        question.addAnswer(answer);

        Assert.assertEquals(answer, question.getAnswers().get(0));
    }

    @Test
    public void getEvaluations() throws Exception {
        Evaluation evaluation1 = new Evaluation();
        Evaluation evaluation2 = new Evaluation();

        List<Evaluation> evaluations = new ArrayList<>();
        evaluations.add(evaluation1);
        evaluations.add(evaluation2);

        question.setEvaluations(evaluations);

        Assert.assertEquals(evaluations, question.getEvaluations());
    }

    @Test
    public void setEvaluations() throws Exception {
        Evaluation evaluation1 = new Evaluation();
        Evaluation evaluation2 = new Evaluation();

        List<Evaluation> evaluations = new ArrayList<>();
        evaluations.add(evaluation1);
        evaluations.add(evaluation2);

        question.setEvaluations(evaluations);

        Assert.assertEquals(evaluations, question.getEvaluations());
    }

    @Test
    public void addEvaluation() throws Exception {
        Evaluation evaluation = new Evaluation();
        question.addEvaluation(evaluation);

        Assert.assertEquals(evaluation, question.getEvaluations().get(0));
    }

}