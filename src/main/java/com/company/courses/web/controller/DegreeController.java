package com.company.courses.web.controller;

import com.company.courses.model.Degree;
import com.company.courses.model.Subject;
import com.company.courses.model.User;
import com.company.courses.services.DegreeService;
import com.company.courses.services.SubjectService;
import com.company.courses.services.UserService;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

@Controller
public class DegreeController {
    @Autowired
    private DegreeService degreeService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private UserService userService;

    @RequestMapping("/degrees")
    public String listDegrees(Model model){
        List<Degree> degrees = degreeService.findAllDegrees();

        model.addAttribute("degrees", degrees);

        return "degree/list";
    }

    @RequestMapping("/degrees/{degreeId}/detail")
    public String degreeDetails(@PathVariable Long degreeId, Model model){
        Degree degree = degreeService.findDegreeById(degreeId);

        model.addAttribute("degree", degree);
        model.addAttribute("subject", degree.getSubject());
        model.addAttribute("teacher", degree.getTeacher());

        return "degree/detail";
    }

    @RequestMapping("/degrees/{degreeId}.png")
    @ResponseBody
    public byte[] degreeImage(@PathVariable Long degreeId){
        return degreeService.findDegreeById(degreeId).getDiploma();
    }

    @RequestMapping("/degrees/degree-form")
    public String degreeForm(Model model){
        model.addAttribute("degree", new Degree());
        model.addAttribute("subjects", subjectService.findAllSubjects());

        return "degree/create";
    }

    @RequestMapping(value = "/degrees/create-degree", method = RequestMethod.POST)
    public String createDegree(Degree degree, @RequestParam MultipartFile file, Principal principal){
        User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        User actualUser = userService.findByUsername(user.getUsername());
        degree.getSubject().getDegree().setSubject(null);
        degree.getSubject().setDegree(degree);
        degree.setTeacher(actualUser);
        actualUser.addCreatedDegree(degree);

        degreeService.save(degree, file);

        return String.format("redirect:/degrees/%s/detail", degree.getId());
    }

    @RequestMapping(value = "/degrees/{degreeId}/delete-degree", method = RequestMethod.POST)
    public String deleteDegree(@PathVariable Long degreeId){
        Degree degree = degreeService.findDegreeById(degreeId);

        if(degree.getUsers() != null){
            for(User user : degree.getUsers()){
                user.removeDegree(degree);
            }
        }

        degree.getTeacher().removeCreatedDegree(degree);

        if(degree.getSubject() != null){
            degree.getSubject().setDegree(null);
        }

        degreeService.delete(degree);

        return "redirect:/degrees";
    }

    @RequestMapping("/degrees/{degreeId}/degree-edit-form")
    public String editDegreeForm(@PathVariable Long degreeId, Model model){
        Degree degree = degreeService.findDegreeById(degreeId);
        List<Subject> subjects = subjectService.findAllSubjects();

        model.addAttribute("degree", degree);
        model.addAttribute("subjects", subjects);

        return "degree/edit";
    }

    @RequestMapping(value = "/degrees/{degreeId}/edit-degree", method = RequestMethod.POST)
    public String editDegree(Degree degree, @RequestParam MultipartFile file){
        List<Subject> subjects = subjectService.findAllSubjects();

        for(Subject subject : subjects){
            if(subject.getDegree() != null && subject.getDegree().getId().equals(degree.getId())){
                subject.setDegree(null);
                break;
            }
        }
        degree.getSubject().getDegree().setSubject(null);
        degree.getSubject().setDegree(degree);
        degreeService.save(degree, file);

        return String.format("redirect:/degrees/%s/detail", degree.getId());
    }
}
