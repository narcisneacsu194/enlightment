package com.company.courses.web.controller;

import com.company.courses.model.Achievement;
import com.company.courses.model.Course;
import com.company.courses.model.Evaluation;
import com.company.courses.model.Subject;
import com.company.courses.services.AchievementService;
import com.company.courses.services.CourseService;
import com.company.courses.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private AchievementService achievementService;

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/courses")
    public String listCourses(Model model){
        List<Course> courses = courseService.findAllCourses();
        model.addAttribute("courses", courses);

        return "course/list";
    }

    @RequestMapping("/courses/{courseId}/detail")
    public String courseDetails(@PathVariable Long courseId, Model model){
        Course course = courseService.findCourseById(courseId);
        Long evaluationId = course.getEvaluations().get(0).getId();
        model.addAttribute("course", course);
        model.addAttribute("subject", course.getSubject());
//        model.addAttribute("achievements", course.getAchievements());
        model.addAttribute("achievement", course.getAchievement());
        model.addAttribute("chapters", course.getChapters());
        model.addAttribute("evaluationId", evaluationId);

        return "course/detail";
    }

    @RequestMapping(value = "/courses/{courseId}.png")
    @ResponseBody
    public byte[] courseImage(@PathVariable Long courseId){
        return courseService.findCourseById(courseId).getImage();
    }

    @RequestMapping("/courses/course-form")
    public String courseForm(Model model){
        List<Achievement> achievements = achievementService.findAllAchievements();
        model.addAttribute("course", new Course());
        model.addAttribute("subjects", subjectService.findAllSubjects());
        model.addAttribute("achievements", achievements);
        return "course/create";
    }

    @RequestMapping(value = "/courses/create-course", method = RequestMethod.POST)
    public String createCourse(Course course, @RequestParam MultipartFile file){
//        List<Achievement> achievements = course.getAchievements();
        Achievement achievement = course.getAchievement();
        achievement.setCourse(course);

//        for(Achievement achievement : achievements){
//            achievement.setCourse(course);
//        }

        Evaluation evaluation = new Evaluation();
        evaluation.setCourse(course);
        course.addEvaluation(evaluation);

        courseService.save(course, file);

        return String.format("redirect:/courses/%s/detail", course.getId());
    }

    @RequestMapping(value = "/courses/{courseId}/delete-course", method = RequestMethod.POST)
    public String deleteCourse(@PathVariable Long courseId){
        Course course = courseService.findCourseById(courseId);
        courseService.delete(course);

        return "redirect:/courses";
    }

    @RequestMapping("/courses/{courseId}/course-edit-form")
    public String editCourseForm(@PathVariable Long courseId, Model model){
        Course course = courseService.findCourseById(courseId);
        List<Achievement> achievements = achievementService.findAllAchievements();
        List<Subject> subjects = subjectService.findAllSubjects();

        model.addAttribute("course", course);
        model.addAttribute("achievements", achievements);
        model.addAttribute("subjects", subjects);

        return "course/edit";
    }

    @RequestMapping(value = "/courses/{coursesId}/edit-course", method = RequestMethod.POST)
    public String editCourse(Course course, @RequestParam MultipartFile file){
//        List<Achievement> achievements = course.getAchievements();
        Achievement achievement = course.getAchievement();
        achievement.setCourse(course);

//        for(Achievement achievement : achievements){
//            achievement.setCourse(course);
//        }

        courseService.save(course, file);

        return String.format("redirect:/courses/%s/detail", course.getId());
    }
}
