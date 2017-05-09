package com.company.courses.web.controller;

import com.company.courses.model.Achievement;
import com.company.courses.model.Course;
import com.company.courses.model.Degree;
import com.company.courses.model.Subject;
import com.company.courses.services.AchievementService;
import com.company.courses.services.CourseService;
import com.company.courses.services.DegreeService;
import com.company.courses.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private AchievementService achievementService;

    @Autowired
    private DegreeService degreeService;

    @RequestMapping("/subjects")
    public String listSubjects(Model model){
        List<Subject> subjects = subjectService.findAllSubjects();
        model.addAttribute("subjects", subjects);
        return "subject/list";
    }

    @RequestMapping(value = "/subjects/{subjectId}/detail")
    public String subjectDetail(@PathVariable Long subjectId, Model model){
        Subject subject = subjectService.findSubjectById(subjectId);
        List<Course> courses = subject.getCourses();
        List<Achievement> achievements = subject.getAchievements();
        List<Degree> degrees = subject.getDegrees();

        model.addAttribute("subject", subject);
        model.addAttribute("courses", courses);
        model.addAttribute("achievements", achievements);
        model.addAttribute("degrees", degrees);

        return "subject/detail";
    }

    @RequestMapping(value = "/subjects/{subjectId}.png")
    @ResponseBody
    public byte[] subjectImage(@PathVariable Long subjectId){
        return subjectService.findSubjectById(subjectId).getImage();
    }

    @RequestMapping("/subjects/subject-form")
    public String subjectForm(Model model){
        model.addAttribute("subject", new Subject());
        model.addAttribute("courses", courseService.findAllCourses());
        model.addAttribute("achievements", achievementService.findAllAchievements());
        model.addAttribute("degrees", degreeService.findAllDegrees());
        return "subject/create";
    }

    @RequestMapping(value = "/subjects/create-subject", method = RequestMethod.POST)
    public String createSubject(Subject subject, @RequestParam MultipartFile file){
        List<Course> courses = subject.getCourses();
        List<Achievement> achievements = subject.getAchievements();
        List<Degree> degrees = subject.getDegrees();

        for(Course course : courses){
            course.setSubject(subject);
        }

        for(Achievement achievement : achievements){
            achievement.setSubject(subject);
        }

        for(Degree degree : degrees){
            degree.setSubject(subject);
        }

        subjectService.save(subject, file);

        return String.format("redirect:/subjects/%s/detail", subject.getId());
    }

    @RequestMapping(value = "/subjects/{subjectId}/delete-subject", method = RequestMethod.POST)
    public String deleteSubject(@PathVariable Long subjectId){
        Subject subject = subjectService.findSubjectById(subjectId);
        List<Degree> degrees = subject.getDegrees();
        List<Course> courses = subject.getCourses();
        List<Achievement> achievements = subject.getAchievements();

        for(Degree degree : degrees){
            degree.setSubject(null);
        }

        for(Course course : courses){
            course.setSubject(null);
        }

        for(Achievement achievement : achievements){
            achievement.setSubject(null);
        }

        subjectService.delete(subject);

        return "redirect:/subjects";
    }

    @RequestMapping("/subjects/{subjectId}/subject-edit-form")
    public String editSubjectForm(@PathVariable Long subjectId, Model model){
        Subject subject = subjectService.findSubjectById(subjectId);
        List<Course> courses = courseService.findAllCourses();
        List<Achievement> achievements = achievementService.findAllAchievements();
        List<Degree> degrees = degreeService.findAllDegrees();

        model.addAttribute("subject", subject);
        model.addAttribute("courses", courses);
        model.addAttribute("achievements", achievements);
        model.addAttribute("degrees", degrees);

        return "subject/edit";
    }

    @RequestMapping(value = "/subjects/{subjectId}/edit-subject", method = RequestMethod.POST)
    public String editSubject(Subject subject, @RequestParam MultipartFile file){
        List<Degree> allDegrees = degreeService.findAllDegrees();
        List<Degree> subjectDegrees = subject.getDegrees();

        for(Degree degree : allDegrees){
            if(!subjectDegrees.contains(degree)){
                degree.setSubject(null);
            }
        }

        for(Degree degree : subjectDegrees){
            degree.setSubject(subject);
        }

        List<Achievement> allAchievements = achievementService.findAllAchievements();
        List<Achievement> subjectAchievements = subject.getAchievements();

        for(Achievement achievement : allAchievements){
            if(!subjectAchievements.contains(achievement)){
                achievement.setSubject(null);
            }
        }

        for(Achievement achievement : subjectAchievements){
            achievement.setSubject(subject);
        }

        List<Course> allCourses = courseService.findAllCourses();
        List<Course> subjectCourses = subject.getCourses();

        for(Course course : allCourses){
            if(!subjectCourses.contains(course)){
                course.setSubject(null);
            }
        }

        for(Course course : subjectCourses){
            course.setSubject(subject);
        }

        subjectService.save(subject, file);

        return String.format("redirect:/subjects/%s/detail", subject.getId());
    }
}
