package com.company.courses.dao;

import com.company.courses.model.Evaluation;
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
        properties = "spring.datasource.url = jdbc:h2:./database/test-EvaluationDaoTest-evaluations;DB_CLOSE_ON_EXIT=FALSE")
public class EvaluationDaoTest {
    @Autowired
    private EvaluationDao evaluationDao;

    @Test
    public void findAll_ShouldReturnAllEvaluations() throws Exception{
        Assert.assertThat(evaluationDao.findAll(), hasSize(1));
    }

    @Test
    public void findOne_ShouldReturnNull() throws Exception{
        Assert.assertThat(evaluationDao.findOne(10L), nullValue(Evaluation.class));
    }

    @Test
    public void findOne_ShouldFindOneEvaluation() throws Exception{
        Assert.assertThat(evaluationDao.findOne(1L), notNullValue(Evaluation.class));
    }

    @Test
    public void save_ShouldSaveEvaluationIntoDatabase() throws Exception{
        Evaluation evaluation = new Evaluation();
        evaluationDao.save(evaluation);
        Evaluation evaluation2 = evaluationDao.findOne(evaluation.getId());

        Assert.assertThat(evaluationDao.findOne(evaluation.getId()), notNullValue(Evaluation.class));
        Assert.assertThat(evaluationDao.findAll(), hasSize(2));

        evaluationDao.delete(evaluation);
    }

    @Test
    public void save_ShouldSaveEvaluationListIntoDatabase() throws Exception{
        Evaluation evaluation1 = new Evaluation();
        Evaluation evaluation2 = new Evaluation();

        List<Evaluation> evaluations = new ArrayList<>();
        evaluations.add(evaluation1);evaluations.add(evaluation2);

        evaluationDao.save(evaluations);

        Assert.assertThat(evaluationDao.findAll(), hasSize(3));
        Assert.assertThat(evaluationDao.findOne(evaluation1.getId()), notNullValue());
        Assert.assertThat(evaluationDao.findOne(evaluation2.getId()), notNullValue());

        evaluationDao.delete(evaluation1);
        evaluationDao.delete(evaluation2);
    }

    @Test
    public void delete_ShouldDeleteEvaluationFromDatabase() throws Exception{
        Evaluation evaluation = new Evaluation();
        evaluationDao.save(evaluation);

        Assert.assertThat(evaluationDao.findOne(evaluation.getId()),
                notNullValue(Evaluation.class));

        Long evaluationId = evaluation.getId();
        evaluationDao.delete(evaluation);

        Assert.assertThat(evaluationDao.findOne(evaluationId),
                nullValue(Evaluation.class));
    }

    @Test
    public void delete_ShouldDeleteEvaluationByIdFromDatabase() throws Exception{
        Evaluation evaluation = new Evaluation();
        evaluationDao.save(evaluation);

        Assert.assertThat(evaluationDao.findOne(evaluation.getId()),
                notNullValue(Evaluation.class));

        Long evaluationId = evaluation.getId();
        evaluationDao.delete(evaluation.getId());

        Assert.assertThat(evaluationDao.findOne(evaluationId),
                nullValue(Evaluation.class));

    }

    @Test
    public void delete_ShouldDeleteEvaluationListFromDatabase() throws Exception{
        Evaluation evaluation1 = new Evaluation();
        Evaluation evaluation2 = new Evaluation();

        List<Evaluation> evaluations = new ArrayList<>();
        evaluations.add(evaluation1);
        evaluations.add(evaluation2);
        evaluationDao.save(evaluations);

        Assert.assertThat(evaluationDao.findAll(), hasSize(3));

        evaluationDao.delete(evaluations);

        Assert.assertThat(evaluationDao.findAll(), hasSize(1));
    }

    @Test
    public void exists_ShouldReturnTrue() throws Exception{
        Assert.assertEquals(true, evaluationDao.exists(1L));
    }

    @Test
    public void exists_ShouldReturnFalse() throws Exception{
        Assert.assertEquals(false, evaluationDao.exists(2L));
    }

}