package com.company.courses.dao;

import com.company.courses.model.Chapter;
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
        properties = "spring.datasource.url = jdbc:h2:./database/evaluation-ChapterDaoTest-chapters;DB_CLOSE_ON_EXIT=FALSE")
public class ChapterDaoTest {
    @Autowired
    private ChapterDao chapterDao;

    @Test
    public void findAll_ShouldReturnAllChapters() throws Exception{
        Assert.assertThat(chapterDao.findAll(), hasSize(1));
    }

    @Test
    public void findOne_ShouldReturnNull() throws Exception{
        Assert.assertThat(chapterDao.findOne(10L), nullValue(Chapter.class));
    }

    @Test
    public void findOne_ShouldFindOneChapter() throws Exception{
        Assert.assertThat(chapterDao.findOne(1L), notNullValue(Chapter.class));
    }

    @Test
    public void save_ShouldSaveChapterIntoDatabase() throws Exception{
        Chapter chapter = new Chapter();
        chapterDao.save(chapter);
        Chapter chapter2 = chapterDao.findOne(chapter.getId());

        Assert.assertThat(chapterDao.findOne(chapter.getId()), notNullValue(Chapter.class));
        Assert.assertThat(chapterDao.findAll(), hasSize(2));

        chapterDao.delete(chapter);
    }

    @Test
    public void save_ShouldSaveChapterListIntoDatabase() throws Exception{
        Chapter chapter1 = new Chapter();
        Chapter chapter2 = new Chapter();

        List<Chapter> chapters = new ArrayList<>();
        chapters.add(chapter1);chapters.add(chapter2);

        chapterDao.save(chapters);

        Assert.assertThat(chapterDao.findAll(), hasSize(3));
        Assert.assertThat(chapterDao.findOne(chapter1.getId()), notNullValue());
        Assert.assertThat(chapterDao.findOne(chapter2.getId()), notNullValue());

        chapterDao.delete(chapter1);
        chapterDao.delete(chapter2);
    }

    @Test
    public void delete_ShouldDeleteChapterFromDatabase() throws Exception{
        Chapter chapter = new Chapter();
        chapterDao.save(chapter);

        Assert.assertThat(chapterDao.findOne(chapter.getId()),
                notNullValue(Chapter.class));

        Long chapterId = chapter.getId();
        chapterDao.delete(chapter);

        Assert.assertThat(chapterDao.findOne(chapterId),
                nullValue(Chapter.class));
    }

    @Test
    public void delete_ShouldDeleteChapterByIdFromDatabase() throws Exception{
        Chapter chapter = new Chapter();
        chapterDao.save(chapter);

        Assert.assertThat(chapterDao.findOne(chapter.getId()),
                notNullValue(Chapter.class));

        Long chapterId = chapter.getId();
        chapterDao.delete(chapter.getId());

        Assert.assertThat(chapterDao.findOne(chapterId),
                nullValue(Chapter.class));

    }

    @Test
    public void delete_ShouldDeleteChapterListFromDatabase() throws Exception{
        Chapter chapter1 = new Chapter();
        Chapter chapter2 = new Chapter();

        List<Chapter> chapters = new ArrayList<>();
        chapters.add(chapter1);
        chapters.add(chapter2);
        chapterDao.save(chapters);

        Assert.assertThat(chapterDao.findAll(), hasSize(3));

        chapterDao.delete(chapters);

        Assert.assertThat(chapterDao.findAll(), hasSize(1));
    }

    @Test
    public void exists_ShouldReturnTrue() throws Exception{
        Assert.assertEquals(true, chapterDao.exists(1L));
    }

    @Test
    public void exists_ShouldReturnFalse() throws Exception{
        Assert.assertEquals(false, chapterDao.exists(2L));
    }

}