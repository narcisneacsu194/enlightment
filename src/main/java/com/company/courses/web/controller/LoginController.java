package com.company.courses.web.controller;

import com.company.courses.model.User;
import com.company.courses.services.RoleService;
import com.company.courses.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/login")
    public String loginForm(Model model){
        model.addAttribute(new User());

        return "user/login";
    }
}
