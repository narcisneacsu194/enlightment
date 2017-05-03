package com.company.courses.model;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChapterTest {

    private Chapter chapter;

    @Before
    public void setUp() throws Exception {
        chapter = new Chapter();
    }

    @After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getId() throws Exception {
        chapter.setId(1L);
        Assert.assertEquals((Long)1L, chapter.getId());
    }

    @Test
    public void setId() throws Exception {
        chapter.setId(1L);
        Assert.assertEquals((Long)1L, chapter.getId());
    }

    @Test
    public void getTitle() throws Exception {
        chapter.setTitle("Random Title");
        Assert.assertEquals("Random Title", chapter.getTitle());
    }

    @Test
    public void setTitle() throws Exception {
        chapter.setTitle("Random Title");
        Assert.assertEquals("Random Title", chapter.getTitle());
    }

    @Test
    public void getContent() throws Exception {
        chapter.setContent("Random Content");
        Assert.assertEquals("Random Content", chapter.getContent());
    }

    @Test
    public void setContent() throws Exception {
        chapter.setContent("Random Content");
        Assert.assertEquals("Random Content", chapter.getContent());
    }

    @Test
    public void getImage() throws Exception {
        byte[] var = new byte[100];
        for(byte i = 0;i < 100;i++){
            var[i] = i;
        }

        chapter.setImage(var);

        Assert.assertEquals(var, chapter.getImage());
    }

    @Test
    public void setImage() throws Exception {
        byte[] var = new byte[100];
        for(byte i = 0;i < 100;i++){
            var[i] = i;
        }

        chapter.setImage(var);

        Assert.assertEquals(var, chapter.getImage());
    }

    @Test
    public void getCourse() throws Exception {
        Course course = new Course();
        course.setName("Random Course Name");
        course.setDescription("Random Course Description");
        course.setDifficulty("medium");
        chapter.setCourse(course);
        Assert.assertEquals(course, chapter.getCourse());
    }

    @Test
    public void setCourse() throws Exception {
        Course course = new Course();
        course.setName("Random Course Name");
        course.setDescription("Random Course Description");
        course.setDifficulty("medium");
        chapter.setCourse(course);
        Assert.assertEquals(course, chapter.getCourse());
    }

}