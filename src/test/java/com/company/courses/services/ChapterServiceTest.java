package com.company.courses.services;

import com.company.courses.dao.ChapterDao;
import com.company.courses.model.Chapter;
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
public class ChapterServiceTest {

    @Mock
    private ChapterDao chapterDao;

    @InjectMocks
    private ChapterService service = new ChapterServiceImpl();

    @Test
    public void findAllChapters() throws Exception {
        Chapter chapter1 = new Chapter();
        Chapter chapter2 = new Chapter();

        List<Chapter> chapters = Arrays.asList(
                chapter1,
                chapter2
        );

        when(chapterDao.findAll()).thenReturn(chapters);

        Assert.assertEquals(2, service.findAllChapters().size());

        verify(chapterDao).findAll();
    }

    @Test
    public void findChapterById() throws Exception {
        Chapter chapter = new Chapter();
        when(chapterDao.findOne(1L)).thenReturn(
                chapter
        );

        Assert.assertEquals(chapter, service.findChapterById(1L));

        verify(chapterDao).findOne(1L);
    }

}