package com.company.courses.dao;

import com.company.courses.model.Degree;
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
        properties = "spring.datasource.url = jdbc:h2:./database/evaluation-DegreeDaoTest-degrees;DB_CLOSE_ON_EXIT=FALSE")
public class DegreeDaoTest {
    @Autowired
    private DegreeDao degreeDao;

    @Test
    public void findAll_ShouldReturnAllDegrees() throws Exception{
        Assert.assertThat(degreeDao.findAll(), hasSize(1));
    }

    @Test
    public void findOne_ShouldReturnNull() throws Exception{
        Assert.assertThat(degreeDao.findOne(10L), nullValue(Degree.class));
    }

    @Test
    public void findOne_ShouldFindOneDegree() throws Exception{
        Assert.assertThat(degreeDao.findOne(1L), notNullValue(Degree.class));
    }

    @Test
    public void save_ShouldSaveDegreeIntoDatabase() throws Exception{
        Degree degree = new Degree();
        degreeDao.save(degree);
        Degree degree2 = degreeDao.findOne(degree.getId());

        Assert.assertThat(degreeDao.findOne(degree.getId()), notNullValue(Degree.class));
        Assert.assertThat(degreeDao.findAll(), hasSize(2));

        degreeDao.delete(degree);
    }

    @Test
    public void save_ShouldSaveDegreeListIntoDatabase() throws Exception{
        Degree degree1 = new Degree();
        Degree degree2 = new Degree();

        List<Degree> degrees = new ArrayList<>();
        degrees.add(degree1);degrees.add(degree2);

        degreeDao.save(degrees);

        Assert.assertThat(degreeDao.findAll(), hasSize(3));
        Assert.assertThat(degreeDao.findOne(degree1.getId()), notNullValue());
        Assert.assertThat(degreeDao.findOne(degree2.getId()), notNullValue());

        degreeDao.delete(degree1);
        degreeDao.delete(degree2);
    }

    @Test
    public void delete_ShouldDeleteDegreeFromDatabase() throws Exception{
        Degree degree = new Degree();
        degreeDao.save(degree);

        Assert.assertThat(degreeDao.findOne(degree.getId()),
                notNullValue(Degree.class));

        Long degreeId = degree.getId();
        degreeDao.delete(degree);

        Assert.assertThat(degreeDao.findOne(degreeId),
                nullValue(Degree.class));
    }

    @Test
    public void delete_ShouldDeleteDegreeByIdFromDatabase() throws Exception{
        Degree degree = new Degree();
        degreeDao.save(degree);

        Assert.assertThat(degreeDao.findOne(degree.getId()),
                notNullValue(Degree.class));

        Long degreeId = degree.getId();
        degreeDao.delete(degree.getId());

        Assert.assertThat(degreeDao.findOne(degreeId),
                nullValue(Degree.class));

    }

    @Test
    public void delete_ShouldDeleteDegreeListFromDatabase() throws Exception{
        Degree degree1 = new Degree();
        Degree degree2 = new Degree();

        List<Degree> degrees = new ArrayList<>();
        degrees.add(degree1);
        degrees.add(degree2);
        degreeDao.save(degrees);

        Assert.assertThat(degreeDao.findAll(), hasSize(3));

        degreeDao.delete(degrees);

        Assert.assertThat(degreeDao.findAll(), hasSize(1));
    }

    @Test
    public void exists_ShouldReturnTrue() throws Exception{
        Assert.assertEquals(true, degreeDao.exists(1L));
    }

    @Test
    public void exists_ShouldReturnFalse() throws Exception{
        Assert.assertEquals(false, degreeDao.exists(2L));
    }

}