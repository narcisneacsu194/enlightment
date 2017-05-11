package com.company.courses.web.controller;

import com.company.courses.model.Achievement;
import com.company.courses.model.Degree;
import com.company.courses.model.User;
import com.company.courses.services.RoleService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/user/profile")
    public String userProfile(Model model, Principal principal){
        User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        User actualUser = userService.findByUsername(user.getUsername());
        List<Achievement> achievements = actualUser.getAchievements();
        List<Degree> degrees = actualUser.getDegrees();
        model.addAttribute("user", actualUser);
        model.addAttribute("achievements", achievements);
        model.addAttribute("degrees", degrees);

        return "user/profile";
    }

    @RequestMapping("/users/{userId}.jpg")
    @ResponseBody
    public byte[] userAvatar(@PathVariable Long userId){
//        User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
//        User actualUser = userService.findByUsername(user.getUsername());
        User user = userService.findUsernameById(userId);
        return user.getAvatar();
    }

    @RequestMapping("/user/user-edit-form")
    public String userEditForm(Model model, Principal principal){
        User user = (User)((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        User actualUser = userService.findByUsername(user.getUsername());
        model.addAttribute("user", actualUser);

        return "user/edit";
    }

    @RequestMapping(value = "/user/edit-user", method = RequestMethod.POST)
    public String editUser(User user, @RequestParam MultipartFile file){
        if(user.isAdmin()){
            user.setRole(roleService.findOne(1L));
        }else{
            user.setRole(roleService.findOne(2L));
        }
        userService.save(user, file);

        return "redirect:/login";
    }

    @RequestMapping("/users/{userId}/detail")
    public String userDetails(@PathVariable Long userId, Model model){
        User user = userService.findUsernameById(userId);

        model.addAttribute("user", user);

        return "user/detail";
    }

}
