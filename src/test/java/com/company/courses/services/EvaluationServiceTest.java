package com.company.courses.services;

import com.company.courses.dao.EvaluationDao;
import com.company.courses.model.Evaluation;
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
public class EvaluationServiceTest {

    @Mock
    private EvaluationDao evaluationDao;

    @InjectMocks
    private EvaluationService service = new EvaluationServiceImpl();

    @Test
    public void findAllEvaluations() throws Exception {
        Evaluation evaluation1 = new Evaluation();
        Evaluation evaluation2 = new Evaluation();

        List<Evaluation> evaluations = Arrays.asList(
                evaluation1,
                evaluation2
        );

        when(evaluationDao.findAll()).thenReturn(evaluations);

        Assert.assertEquals(2, service.findAllEvaluations().size());

        verify(evaluationDao).findAll();
    }

    @Test
    public void findEvaluationById() throws Exception {
        Evaluation evaluation = new Evaluation();
        when(evaluationDao.findOne(1L)).thenReturn(
                evaluation
        );

        Assert.assertEquals(evaluation, service.findEvaluationById(1L));

        verify(evaluationDao).findOne(1L);
    }

}