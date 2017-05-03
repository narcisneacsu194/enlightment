package com.company.courses.services;

import com.company.courses.dao.QuestionDao;
import com.company.courses.model.Question;
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
public class QuestionServiceTest {

    @Mock
    private QuestionDao questionDao;

    @InjectMocks
    private QuestionService service = new QuestionServiceImpl();

    @Test
    public void findAllQuestions() throws Exception {
        Question question1 = new Question();
        Question question2 = new Question();

        List<Question> questions = Arrays.asList(
                question1,
                question2
        );

        when(questionDao.findAll()).thenReturn(questions);

        Assert.assertEquals(2, service.findAllQuestions().size());

        verify(questionDao).findAll();
    }

    @Test
    public void findQuestionById() throws Exception {
        Question question = new Question();
        when(questionDao.findOne(1L)).thenReturn(
                question
        );

        Assert.assertEquals(question, service.findQuestionById(1L));

        verify(questionDao).findOne(1L);
    }

}