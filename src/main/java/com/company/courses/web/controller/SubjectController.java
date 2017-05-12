package com.company.courses.web.controller;

import com.company.courses.model.*;
import com.company.courses.services.*;
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
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private AchievementService achievementService;

    @Autowired
    private DegreeService degreeService;

    @Autowired
    private UserService userService;

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
//        List<Degree> degrees = subject.getDegrees();
        Degree degree = subject.getDegree();

        model.addAttribute("subject", subject);
        model.addAttribute("courses", courses);
        model.addAttribute("achievements", achievements);
        model.addAttribute("degree", degree);
        model.addAttribute("teacher", subject.getTeacher());

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
    public String createSubject(Subject subject, @RequestParam MultipartFile file, Principal principal){
        List<Course> courses = subject.getCourses();
        List<Achievement> achievements = subject.getAchievements();
        Degree degree = subject.getDegree();

        for(Course course : courses){
            course.setSubject(subject);
        }

        for(Achievement achievement : achievements){
            achievement.setSubject(subject);
        }

        degree.setSubject(subject);

        User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        User actualUser = userService.findByUsername(user.getUsername());

        subject.setTeacher(actualUser);
        actualUser.addCreatedSubject(subject);

        subjectService.save(subject, file);

        return String.format("redirect:/subjects/%s/detail", subject.getId());
    }

    @RequestMapping(value = "/subjects/{subjectId}/delete-subject", method = RequestMethod.POST)
    public String deleteSubject(@PathVariable Long subjectId){
        Subject subject = subjectService.findSubjectById(subjectId);
        Degree degree = subject.getDegree();
        List<Course> courses = subject.getCourses();
        List<Achievement> achievements = subject.getAchievements();
        User user = subject.getTeacher();
        user.removeCreatedSubject(subject);

        degree.setSubject(null);

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
        for(Degree degree : allDegrees){
            if(degree.getSubject() != null && degree.getSubject()
                    .getId().equals(subject.getId())){
                degree.setSubject(null);
                break;
            }
        }
        Degree degree = subject.getDegree();
        degree.setSubject(subject);

        List<Achievement> allAchievements = achievementService.findAllAchievements();

        for(Achievement achievement : allAchievements){
            if(achievement.getSubject() != null && achievement.getSubject().getId().equals(subject.getId())){
                achievement.setSubject(null);
            }
        }


        List<Achievement> subjectAchievements = subject.getAchievements();

        for(Achievement achievement : subjectAchievements){
            achievement.getSubject().removeAchievement(achievement);
            achievement.setSubject(subject);
        }


        List<Course> allCourses = courseService.findAllCourses();

        for(Course course : allCourses){
            if(course.getSubject() != null && course.getSubject().getId().equals(subject.getId())){
                course.setSubject(null);
            }
        }


        List<Course> subjectCourses = subject.getCourses();

        for(Course course : subjectCourses){
            course.getSubject().removeCourse(course);
            course.setSubject(subject);
        }

        subjectService.save(subject, file);

        return String.format("redirect:/subjects/%s/detail", subject.getId());
    }
}
