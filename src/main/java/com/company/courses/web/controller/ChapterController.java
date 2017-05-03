package com.company.courses.web.controller;

import com.company.courses.model.Chapter;
import com.company.courses.model.Course;
import com.company.courses.services.ChapterService;
import com.company.courses.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/chapters/{chapterId}/detail")
    public String chapterDetail(@PathVariable Long chapterId, Model model){
        Chapter chapter = chapterService.findChapterById(chapterId);
        Course course = chapter.getCourse();
        List<Chapter> chapters = course.getChapters();
        List<Chapter> previousChapters = chapters.subList(0, (int)(chapter.getId()-1));// 0 1 2
        List<Chapter> nextChapters = chapters.subList(chapter.getId().intValue(), chapters.size());

        model.addAttribute("chapter", chapter);
        model.addAttribute("course", course);
        model.addAttribute("previousChapters", previousChapters);
        model.addAttribute("nextChapters", nextChapters);

        return "chapter/detail";
    }

    @RequestMapping("/chapters/{chapterId}/chapter-edit-form")
    public String chapterEditForm(@PathVariable Long chapterId, Model model){
        Chapter chapter = chapterService.findChapterById(chapterId);
        List<Course> courses = courseService.findAllCourses();
        model.addAttribute("chapter", chapter);
        model.addAttribute("courses", courses);

        return "chapter/edit";
    }

    @RequestMapping(value = "/chapters/{chapterId}/edit-chapter", method = RequestMethod.POST)
    public String editChapter(Chapter chapter, @RequestParam MultipartFile file){
        chapterService.save(chapter, file);

        return String.format("redirect:/chapters/%s/detail", chapter.getId());
    }

    @RequestMapping(value = "/chapters/{chapterId}/delete-chapter", method = RequestMethod.POST)
    public String deleteChapter(@PathVariable Long chapterId){
        Chapter chapter = chapterService.findChapterById(chapterId);
        Long courseId = chapter.getCourse().getId();

        chapterService.delete(chapter);

        return String.format("redirect:/courses/%s/detail", courseId);
    }

    @RequestMapping("/chapters/{chapterId}.png")
    @ResponseBody
    public byte[] chapterImage(@PathVariable Long chapterId){
        return chapterService.findChapterById(chapterId).getImage();
    }
}
