package com.company.courses.web.controller;

import com.company.courses.model.Achievement;
import com.company.courses.model.Course;
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
public class AchievementController {
    @Autowired
    private AchievementService achievementService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/achievements")
    public String listAchievements(Model model){
        List<Achievement> achievements = achievementService.findAllAchievements();

        model.addAttribute("achievements", achievements);

        return "achievement/list";
    }

    @RequestMapping("/achievements/{achievementId}/detail")
    public String achievementDetails(@PathVariable Long achievementId, Model model){
        Achievement achievement = achievementService.findAchievementById(achievementId);

        model.addAttribute("achievement", achievement);
        model.addAttribute("subject", achievement.getSubject());
        model.addAttribute("course", achievement.getCourse());

        return "achievement/detail";
    }

    @RequestMapping("/achievements/{achievementId}.png")
    @ResponseBody
    public byte[] achievementImage(@PathVariable Long achievementId){
        return achievementService.findAchievementById(achievementId).getBadge();
    }

    @RequestMapping("/achievements/achievement-form")
    public String achievementForm(Model model){
        model.addAttribute("achievement", new Achievement());
        model.addAttribute("subjects", subjectService.findAllSubjects());
        model.addAttribute("courses", courseService.findAllCourses());

        return "achievement/create";
    }

    @RequestMapping(value = "/achievements/create-achievement", method = RequestMethod.POST)
    public String createAchievement(Achievement achievement, @RequestParam MultipartFile file){
        achievementService.save(achievement, file);

        return String.format("redirect:/achievements/%s/detail", achievement.getId());
    }

    @RequestMapping(value = "/achievements/{achievementId}/delete-achievement", method = RequestMethod.POST)
    public String deleteAchievement(@PathVariable Long achievementId){
        Achievement achievement = achievementService.findAchievementById(achievementId);

        achievementService.delete(achievement);

        return "redirect:/achievements";
    }

    @RequestMapping("/achievements/{achievementId}/achievement-edit-form")
    public String editAchievementForm(@PathVariable Long achievementId, Model model){
        Achievement achievement = achievementService.findAchievementById(achievementId);
        List<Subject> subjects = subjectService.findAllSubjects();
        List<Course> courses = courseService.findAllCourses();

        model.addAttribute("achievement", achievement);
        model.addAttribute("subjects", subjects);
        model.addAttribute("courses", courses);

        return "achievement/edit";
    }

    @RequestMapping(value = "/achievements/{achievementId}/edit-achievement", method = RequestMethod.POST)
    public String editAchievement(Achievement achievement, @RequestParam MultipartFile file){

        achievementService.save(achievement, file);

        return String.format("redirect:/achievements/%s/detail", achievement.getId());
    }
}
