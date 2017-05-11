package com.company.courses.web.controller;

import com.company.courses.model.User;
import com.company.courses.services.RoleService;
import com.company.courses.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

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

        model.addAttribute("user", actualUser);

        return "user/detail";
    }

    @RequestMapping("/user.jpg")
    @ResponseBody
    public byte[] userAvatar(Principal principal){
        User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        User actualUser = userService.findByUsername(user.getUsername());
        return actualUser.getAvatar();
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

}
