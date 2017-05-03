package com.company.courses.model;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class DegreeTest {

    private Degree degree;

    @Before
    public void setUp() throws Exception {
        degree = new Degree();
    }

    @After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getId() throws Exception {
        degree.setId(1L);
        Assert.assertEquals((Long)1L, degree.getId());
    }

    @Test
    public void setId() throws Exception {
        degree.setId(1L);
        Assert.assertEquals((Long)1L, degree.getId());
    }

    @Test
    public void getName() throws Exception {
        degree.setName("Random Name");
        Assert.assertEquals("Random Name", degree.getName());
    }

    @Test
    public void setName() throws Exception {
        degree.setName("Random Name");
        Assert.assertEquals("Random Name", degree.getName());
    }

    @Test
    public void getDescription() throws Exception {
        degree.setDescription("Random Description");
        Assert.assertEquals("Random Description", degree.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        degree.setDescription("Random Description");
        Assert.assertEquals("Random Description", degree.getDescription());
    }

    @Test
    public void getDiploma() throws Exception {
        byte[] var = new byte[100];
        for(byte i = 0;i < 100;i++){
            var[i] = i;
        }

        degree.setDiploma(var);

        Assert.assertEquals(var, degree.getDiploma());
    }

    @Test
    public void setDiploma() throws Exception {
        byte[] var = new byte[100];
        for(byte i = 0;i < 100;i++){
            var[i] = i;
        }

        degree.setDiploma(var);

        Assert.assertEquals(var, degree.getDiploma());
    }

    @Test
    public void getSubject() throws Exception {
        Subject subject = new Subject();
        subject.setName("Random Name");
        subject.setDescription("Random Description");

        degree.setSubject(subject);

        Assert.assertEquals(subject, degree.getSubject());
    }

    @Test
    public void setSubject() throws Exception {
        Subject subject = new Subject();
        subject.setName("Random Name");
        subject.setDescription("Random Description");

        degree.setSubject(subject);

        Assert.assertEquals(subject, degree.getSubject());
    }

}