package com.company.courses.services;

import com.company.courses.model.Chapter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChapterService {
    List<Chapter> findAllChapters();
    Chapter findChapterById(Long chapterId);
    void save(Chapter chapter, MultipartFile file);
    void delete(Chapter chapter);
}
