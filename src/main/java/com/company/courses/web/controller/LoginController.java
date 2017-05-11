package com.company.courses.web.controller;

import com.company.courses.model.User;
import com.company.courses.services.RoleService;
import com.company.courses.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;

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

    @RequestMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());

        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(User user, @RequestParam MultipartFile file){

        if(!user.getPassword().equals(user.getMatchingPassword())){
            return "redirect:/login";
        }

        user.encodePasswords();
        user.setRole(roleService.findOne(2L));
        user.setEnabled(true);
        user.setDateOfRegistration(Instant.now());

        userService.save(user, file);

        return "redirect:/login";
    }
}
