package com.company.courses.web.controller;

import com.company.courses.model.Achievement;
import com.company.courses.model.Course;
import com.company.courses.model.Subject;
import com.company.courses.model.User;
import com.company.courses.services.AchievementService;
import com.company.courses.services.CourseService;
import com.company.courses.services.SubjectService;
import com.company.courses.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

@Controller
public class AchievementController {
    @Autowired
    private AchievementService achievementService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

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
        model.addAttribute("teacher", achievement.getTeacher());

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
    public String createAchievement(Achievement achievement, @RequestParam MultipartFile file, Principal principal){
        User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        User actualUser = userService.findByUsername(user.getUsername());
        if(achievement.getCourse().getAchievement() != null){
            achievement.getCourse().getAchievement().setCourse(null);
        }

        achievement.getCourse().setAchievement(achievement);
        achievement.setTeacher(actualUser);
        actualUser.addCreatedAchievement(achievement);

        achievementService.save(achievement, file);

        return String.format("redirect:/achievements/%s/detail", achievement.getId());
    }

    @RequestMapping(value = "/achievements/{achievementId}/delete-achievement", method = RequestMethod.POST)
    public String deleteAchievement(@PathVariable Long achievementId){
        Achievement achievement = achievementService.findAchievementById(achievementId);
        if(achievement.getCourse() != null){
            achievement.getCourse().setAchievement(null);
        }

        if(achievement.getSubject() != null){
            achievement.getSubject().removeAchievement(achievement);
        }

        if(achievement.getUsers() != null){
            for(User user : achievement.getUsers()){
                user.removeAchievement(achievement);
            }
        }

        achievement.getTeacher().removeCreatedAchievement(achievement);

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
        Achievement achievement1 = achievement.getCourse().getAchievement();
        if(achievement1 != null){
            achievement1.setCourse(null);
        }

        for(Course course : courseService.findAllCourses()){
            if(course.getAchievement() != null && course.getAchievement().getId().equals(achievement.getId())){
                course.setAchievement(null);
            }
        }

        Course course = achievement.getCourse(); // course = encapsulation
        course.setAchievement(achievement);
        achievementService.save(achievement, file);

        return String.format("redirect:/achievements/%s/detail", achievement.getId());
    }
}
