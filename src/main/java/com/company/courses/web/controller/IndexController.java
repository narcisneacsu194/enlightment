package com.company.courses.web.controller;

import com.company.courses.model.Course;
import com.company.courses.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private CourseService service;

    @RequestMapping("/")
    public String homePage(Model model) {
        List<Course> courses = service.findAllCourses();
        model.addAttribute("courses", courses);
        return "index";
    }

    @RequestMapping("/contact")
    public String contactPage(){
        return "contact/index";
    }
}
