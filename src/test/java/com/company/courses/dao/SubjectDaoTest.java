package com.company.courses.dao;

import com.company.courses.model.Subject;
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
        properties = "spring.datasource.url = jdbc:h2:./database/evaluation-SubjectDaoTest-subjects;DB_CLOSE_ON_EXIT=FALSE")
public class SubjectDaoTest {
    @Autowired
    private SubjectDao subjectDao;

    @Test
    public void findAll_ShouldReturnAllSubjects() throws Exception{
        Assert.assertThat(subjectDao.findAll(), hasSize(1));
    }

    @Test
    public void findOne_ShouldReturnNull() throws Exception{
        Assert.assertThat(subjectDao.findOne(10L), nullValue(Subject.class));
    }

    @Test
    public void findOne_ShouldFindOneSubject() throws Exception{
        Assert.assertThat(subjectDao.findOne(1L), notNullValue(Subject.class));
    }

    @Test
    public void save_ShouldSaveSubjectIntoDatabase() throws Exception{
        Subject subject = new Subject();
        subjectDao.save(subject);
        Subject subject2 = subjectDao.findOne(subject.getId());

        Assert.assertThat(subjectDao.findOne(subject.getId()), notNullValue(Subject.class));
        Assert.assertThat(subjectDao.findAll(), hasSize(2));

        subjectDao.delete(subject);
    }

    @Test
    public void save_ShouldSaveSubjectListIntoDatabase() throws Exception{
        Subject subject1 = new Subject();
        Subject subject2 = new Subject();

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);subjects.add(subject2);

        subjectDao.save(subjects);

        Assert.assertThat(subjectDao.findAll(), hasSize(3));
        Assert.assertThat(subjectDao.findOne(subject1.getId()), notNullValue());
        Assert.assertThat(subjectDao.findOne(subject2.getId()), notNullValue());

        subjectDao.delete(subject1);
        subjectDao.delete(subject2);
    }

    @Test
    public void delete_ShouldDeleteSubjectFromDatabase() throws Exception{
        Subject subject = new Subject();
        subjectDao.save(subject);

        Assert.assertThat(subjectDao.findOne(subject.getId()),
                notNullValue(Subject.class));

        Long subjectId = subject.getId();
        subjectDao.delete(subject);

        Assert.assertThat(subjectDao.findOne(subjectId),
                nullValue(Subject.class));
    }

    @Test
    public void delete_ShouldDeleteSubjectByIdFromDatabase() throws Exception{
        Subject subject = new Subject();
        subjectDao.save(subject);

        Assert.assertThat(subjectDao.findOne(subject.getId()),
                notNullValue(Subject.class));

        Long subjectId = subject.getId();
        subjectDao.delete(subject.getId());

        Assert.assertThat(subjectDao.findOne(subjectId),
                nullValue(Subject.class));

    }

    @Test
    public void delete_ShouldDeleteSubjectListFromDatabase() throws Exception{
        Subject subject1 = new Subject();
        Subject subject2 = new Subject();

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjectDao.save(subjects);

        Assert.assertThat(subjectDao.findAll(), hasSize(3));

        subjectDao.delete(subjects);

        Assert.assertThat(subjectDao.findAll(), hasSize(1));
    }

    @Test
    public void exists_ShouldReturnTrue() throws Exception{
        Assert.assertEquals(true, subjectDao.exists(1L));
    }

    @Test
    public void exists_ShouldReturnFalse() throws Exception{
        Assert.assertEquals(false, subjectDao.exists(2L));
    }

}