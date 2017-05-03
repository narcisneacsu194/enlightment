package com.company.courses.services;

import com.company.courses.dao.AnswerDao;
import com.company.courses.model.Answer;
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
public class AnswerServiceTest {

    @Mock
    private AnswerDao answerDao;

    @InjectMocks
    private AnswerService service = new AnswerServiceImpl();

    @Test
    public void findAllAnswers() throws Exception {
        Answer answer1 = new Answer();
        Answer answer2 = new Answer();

        List<Answer> answers = Arrays.asList(
                answer1,
                answer2
        );

        when(answerDao.findAll()).thenReturn(answers);

        Assert.assertEquals(2, service.findAllAnswers().size());

        verify(answerDao).findAll();
    }

    @Test
    public void findAnswerById() throws Exception {
        Answer answer = new Answer();
        when(answerDao.findOne(1L)).thenReturn(
                answer
        );

        Assert.assertEquals(answer, service.findAnswerById(1L));

        verify(answerDao).findOne(1L);
    }

}