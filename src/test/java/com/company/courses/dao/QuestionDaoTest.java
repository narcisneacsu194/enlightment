package com.company.courses.dao;

import com.company.courses.model.Question;
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
        properties = "spring.datasource.url = jdbc:h2:./database/test-QuestionDaoTest-questions;DB_CLOSE_ON_EXIT=FALSE")
public class QuestionDaoTest {
    @Autowired
    private QuestionDao questionDao;

    @Test
    public void findAll_ShouldReturnAllQuestions() throws Exception{
        Assert.assertThat(questionDao.findAll(), hasSize(1));
    }

    @Test
    public void findOne_ShouldReturnNull() throws Exception{
        Assert.assertThat(questionDao.findOne(10L), nullValue(Question.class));
    }

    @Test
    public void findOne_ShouldFindOneQuestion() throws Exception{
        Assert.assertThat(questionDao.findOne(1L), notNullValue(Question.class));
    }

    @Test
    public void save_ShouldSaveQuestionIntoDatabase() throws Exception{
        Question question = new Question();
        questionDao.save(question);
        Question question2 = questionDao.findOne(question.getId());

        Assert.assertThat(questionDao.findOne(question.getId()), notNullValue(Question.class));
        Assert.assertThat(questionDao.findAll(), hasSize(2));

        questionDao.delete(question);
    }

    @Test
    public void save_ShouldSaveQuestionListIntoDatabase() throws Exception{
        Question question1 = new Question();
        Question question2 = new Question();

        List<Question> questions = new ArrayList<>();
        questions.add(question1);questions.add(question2);

        questionDao.save(questions);

        Assert.assertThat(questionDao.findAll(), hasSize(3));
        Assert.assertThat(questionDao.findOne(question1.getId()), notNullValue());
        Assert.assertThat(questionDao.findOne(question2.getId()), notNullValue());

        questionDao.delete(question1);
        questionDao.delete(question2);
    }

    @Test
    public void delete_ShouldDeleteQuestionFromDatabase() throws Exception{
        Question question = new Question();
        questionDao.save(question);

        Assert.assertThat(questionDao.findOne(question.getId()),
                notNullValue(Question.class));

        Long questionId = question.getId();
        questionDao.delete(question);

        Assert.assertThat(questionDao.findOne(questionId),
                nullValue(Question.class));
    }

    @Test
    public void delete_ShouldDeleteQuestionByIdFromDatabase() throws Exception{
        Question question = new Question();
        questionDao.save(question);

        Assert.assertThat(questionDao.findOne(question.getId()),
                notNullValue(Question.class));

        Long questionId = question.getId();
        questionDao.delete(question.getId());

        Assert.assertThat(questionDao.findOne(questionId),
                nullValue(Question.class));

    }

    @Test
    public void delete_ShouldDeleteQuestionListFromDatabase() throws Exception{
        Question question1 = new Question();
        Question question2 = new Question();

        List<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questionDao.save(questions);

        Assert.assertThat(questionDao.findAll(), hasSize(3));

        questionDao.delete(questions);

        Assert.assertThat(questionDao.findAll(), hasSize(1));
    }

    @Test
    public void exists_ShouldReturnTrue() throws Exception{
        Assert.assertEquals(true, questionDao.exists(1L));
    }

    @Test
    public void exists_ShouldReturnFalse() throws Exception{
        Assert.assertEquals(false, questionDao.exists(2L));
    }

}