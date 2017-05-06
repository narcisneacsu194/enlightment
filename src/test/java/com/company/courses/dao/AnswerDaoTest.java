package com.company.courses.dao;

import com.company.courses.model.Answer;
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
        properties = "spring.datasource.url = jdbc:h2:./database/evaluation-AnswerDaoTest-answers;DB_CLOSE_ON_EXIT=FALSE")
public class AnswerDaoTest {
    @Autowired
    private AnswerDao answerDao;

    @Test
    public void findAll_ShouldReturnAllAnswers() throws Exception{
        Assert.assertThat(answerDao.findAll(), hasSize(1));
    }

    @Test
    public void findOne_ShouldReturnNull() throws Exception{
        Assert.assertThat(answerDao.findOne(10L), nullValue(Answer.class));
    }

    @Test
    public void findOne_ShouldFindOneAnswer() throws Exception{
        Assert.assertThat(answerDao.findOne(1L), notNullValue(Answer.class));
    }

    @Test
    public void save_ShouldSaveAnswerIntoDatabase() throws Exception{
        Answer answer = new Answer();
        answer.setDescription("Random Description 2");
        answerDao.save(answer);
        Answer answer2 = answerDao.findOne(answer.getId());

        Assert.assertThat(answerDao.findOne(answer.getId()), notNullValue(Answer.class));
        Assert.assertEquals(answer.getDescription(), answer2.getDescription());
        Assert.assertThat(answerDao.findAll(), hasSize(2));

        answerDao.delete(answer);
    }

    @Test
    public void save_ShouldSaveAnswerListIntoDatabase() throws Exception{
        Answer answer1 = new Answer();
        answer1.setDescription("Random Description 1");
        Answer answer2 = new Answer();
        answer2.setDescription("Random Description 2");

        List<Answer> answers = new ArrayList<>();
        answers.add(answer1);answers.add(answer2);

        answerDao.save(answers);

        Assert.assertThat(answerDao.findAll(), hasSize(3));
        Assert.assertThat(answerDao.findOne(answer1.getId()), notNullValue());
        Assert.assertThat(answerDao.findOne(answer2.getId()), notNullValue());

        answerDao.delete(answer1);
        answerDao.delete(answer2);
    }

    @Test
    public void delete_ShouldDeleteAnswerFromDatabase() throws Exception{
        Answer answer = new Answer();
        answer.setDescription("Random Description 2");
        answerDao.save(answer);

        Assert.assertThat(answerDao.findOne(answer.getId()),
                notNullValue(Answer.class));

        Long answerId = answer.getId();
        answerDao.delete(answer);

        Assert.assertThat(answerDao.findOne(answerId),
                nullValue(Answer.class));
    }

    @Test
    public void delete_ShouldDeleteAnswerByIdFromDatabase() throws Exception{
        Answer answer = new Answer();
        answerDao.save(answer);

        Assert.assertThat(answerDao.findOne(answer.getId()),
                notNullValue(Answer.class));

        Long answerId = answer.getId();
        answerDao.delete(answer.getId());

        Assert.assertThat(answerDao.findOne(answerId),
                nullValue(Answer.class));

    }

    @Test
    public void delete_ShouldDeleteAnswerListFromDatabase() throws Exception{
        Answer answer1 = new Answer();
        Answer answer2 = new Answer();

        List<Answer> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);
        answerDao.save(answers);

        Assert.assertThat(answerDao.findAll(), hasSize(3));

        answerDao.delete(answers);

        Assert.assertThat(answerDao.findAll(), hasSize(1));
    }

    @Test
    public void exists_ShouldReturnTrue() throws Exception{
        Assert.assertEquals(true, answerDao.exists(1L));
    }

    @Test
    public void exists_ShouldReturnFalse() throws Exception{
        Assert.assertEquals(false, answerDao.exists(2L));
    }

}