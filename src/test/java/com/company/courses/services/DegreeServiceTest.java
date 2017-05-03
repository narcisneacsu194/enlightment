package com.company.courses.services;

import com.company.courses.dao.DegreeDao;
import com.company.courses.model.Degree;
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
public class DegreeServiceTest {

    @Mock
    private DegreeDao degreeDao;

    @InjectMocks
    private DegreeService service = new DegreeServiceImpl();

    @Test
    public void findAllDegrees() throws Exception {
        Degree degree1 = new Degree();
        Degree degree2 = new Degree();

        List<Degree> degrees = Arrays.asList(
                degree1,
                degree2
        );

        when(degreeDao.findAll()).thenReturn(degrees);

        Assert.assertEquals(2, service.findAllDegrees().size());

        verify(degreeDao).findAll();
    }

    @Test
    public void findDegreeById() throws Exception {
        Degree degree = new Degree();
        degree.setName("Random Name");
        when(degreeDao.findOne(1L)).thenReturn(
                degree
        );

        Assert.assertEquals(degree, service.findDegreeById(1L));

        verify(degreeDao).findOne(1L);
    }

}