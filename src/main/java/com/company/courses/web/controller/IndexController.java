package com.company.courses.web.controller;

import com.company.courses.model.Course;
import com.company.courses.model.User;
import com.company.courses.services.CourseService;
import com.company.courses.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String homePage(Model model) {
        List<Course> courses = courseService.findAllCourses();
        List<User> teachers = new ArrayList<>();

        for(User user : userService.findAll()){
            if(user.isAdmin()){
                teachers.add(user);
            }
        }

        model.addAttribute("courses", courses);
        model.addAttribute("teachers", teachers);
        return "index";
    }

    @RequestMapping("/contact")
    public String contactPage(){
        return "contact/index";
    }
}
