package com.company.courses.web.controller;

import com.company.courses.model.Answer;
import com.company.courses.model.Course;
import com.company.courses.model.Evaluation;
import com.company.courses.model.Question;
import com.company.courses.services.CourseService;
import com.company.courses.services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/evaluations/{evaluationId}/evaluation-page")
    public String displayQuestions(@PathVariable Long evaluationId, Model model){

        Evaluation evaluation = evaluationService.findEvaluationById(evaluationId);
        Course course = evaluation.getCourse();
        List<Question> questions = evaluation.getQuestions();

        model.addAttribute("courseName", course.getName());
        model.addAttribute("evaluation", evaluation);
        model.addAttribute("tempQuestions", questions);

        return "evaluation/detail";
    }

    @RequestMapping(value = "/evaluation/{evaluationId}/process-evaluation", method = RequestMethod.POST)
    public String processEvaluation(Evaluation evaluation){
        List<Answer> userAnswers = evaluation.getUserAnswers();
        List<Answer> correctAnswers = evaluation.getCorrectAnswers();
        int percentage = sumUpMatchedAnswers(userAnswers, correctAnswers);
        evaluation.setPercentage(percentage);
        evaluation.setUserAnswers(new ArrayList<>());
        evaluationService.save(evaluation);

        return String.format("redirect:/evaluations/%s/evaluation-result-page", evaluation.getId());
    }

    private int sumUpMatchedAnswers(List<Answer> userAnswers, List<Answer> correctAnswers) {
        String userDescription;
//        String correctDescription;
        List<String> correctDescriptions = new ArrayList<>();
        for(Answer answer : correctAnswers){
            correctDescriptions.add(answer.getDescription());
        }
        int percentage;
        double noMatchedAnswers = 0;
        double doublePercent;
        for(int i = 0;i < userAnswers.size();i++){
            userDescription = userAnswers.get(i).getDescription();
//            correctDescription = correctAnswers.get(i).getDescription();
            if(correctDescriptions.contains(userDescription))noMatchedAnswers++;
        }

        doublePercent = (noMatchedAnswers / correctAnswers.size()) * 100;
        percentage = (int)doublePercent;

        return percentage;
    }

    @RequestMapping("/evaluations/{evaluationId}/evaluation-result-page")
    public String evaluationResult(@PathVariable Long evaluationId, Model model){
        Evaluation evaluation = evaluationService.findEvaluationById(evaluationId);
        Course course = evaluation.getCourse();

        model.addAttribute("course", course);
        model.addAttribute("evaluation", evaluation);
        model.addAttribute("questions", evaluation.getQuestions());

        return "evaluation/result";
    }

}
