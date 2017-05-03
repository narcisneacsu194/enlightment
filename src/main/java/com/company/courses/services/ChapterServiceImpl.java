package com.company.courses.services;

import com.company.courses.dao.ChapterDao;
import com.company.courses.model.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService{
    @Autowired
    private ChapterDao chapterDao;

    @Override
    @SuppressWarnings("unchecked")
    public List<Chapter> findAllChapters() {
        return (List)chapterDao.findAll();
    }

    @Override
    public Chapter findChapterById(Long chapterId) {
        return chapterDao.findOne(chapterId);
    }

    @Override
    public void save(Chapter chapter, MultipartFile file) {
        try {
            chapter.setImage(file.getBytes());
            chapterDao.save(chapter);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Override
    public void delete(Chapter chapter) {
        chapterDao.delete(chapter);
    }
}
