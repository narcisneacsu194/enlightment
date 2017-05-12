package com.company.courses.web.controller;

import com.company.courses.model.Chapter;
import com.company.courses.model.Course;
import com.company.courses.model.User;
import com.company.courses.services.ChapterService;
import com.company.courses.services.CourseService;
import com.company.courses.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @RequestMapping("/chapters/{chapterId}/detail")
    public String chapterDetail(@PathVariable Long chapterId, Model model){
        Chapter chapter = chapterService.findChapterById(chapterId);
        Course course = chapter.getCourse();
        List<Chapter> chapters = course.getChapters();
        List<Chapter> previousChapters = chapters.subList(0, chapters.indexOf(chapter));
        List<Chapter> nextChapters = chapters.subList(chapters.indexOf(chapter)+1, chapters.size());

        model.addAttribute("chapter", chapter);
        model.addAttribute("course", course);
        model.addAttribute("previousChapters", previousChapters);
        model.addAttribute("nextChapters", nextChapters);
        model.addAttribute("teacher", chapter.getTeacher());

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
        for(Course course : courseService.findAllCourses()){
            if(course.getChapters().contains(chapter)){
                course.getChapters().remove(chapter);
                break;
            }
        }

        chapter.getCourse().addChapter(chapter);

        chapterService.save(chapter, file);

        return String.format("redirect:/chapters/%s/detail", chapter.getId());
    }

    @RequestMapping(value = "/chapters/{chapterId}/delete-chapter", method = RequestMethod.POST)
    public String deleteChapter(@PathVariable Long chapterId){
        Chapter chapter = chapterService.findChapterById(chapterId);
        Long courseId = chapter.getCourse().getId();

        chapter.getTeacher().removeCreatedChapter(chapter);

        chapterService.delete(chapter);

        return String.format("redirect:/courses/%s/detail", courseId);
    }

    @RequestMapping("/chapters/{chapterId}.png")
    @ResponseBody
    public byte[] chapterImage(@PathVariable Long chapterId){
        return chapterService.findChapterById(chapterId).getImage();
    }

    @RequestMapping("/chapters/chapter-form")
    public String chapterForm(Model model){
        model.addAttribute("chapter", new Chapter());
        model.addAttribute("courses", courseService.findAllCourses());

        return "chapter/create";
    }

    @RequestMapping(value = "/chapters/create-chapter", method = RequestMethod.POST)
    public String createChapter(Chapter chapter, @RequestParam MultipartFile file, Principal principal){
        User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        User actualUser = userService.findByUsername(user.getUsername());

        chapter.getCourse().addChapter(chapter);
        chapter.setTeacher(actualUser);
        actualUser.addCreatedChapter(chapter);
        chapterService.save(chapter, file);

        return String.format("redirect:/chapters/%s/detail", chapter.getId());
    }
}
