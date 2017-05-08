package com.company.courses.web.controller;

import com.company.courses.model.Answer;
import com.company.courses.model.Course;
import com.company.courses.model.Evaluation;
import com.company.courses.model.Question;
import com.company.courses.services.CourseService;
import com.company.courses.services.EvaluationService;
import com.company.courses.services.QuestionService;
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

    @Autowired
    private QuestionService questionService;

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

    @RequestMapping("/evaluations/evaluation-form")
    public String evaluationForm(Model model){
        List<Course> courses = courseService.findAllCourses();
        model.addAttribute("evaluation", new Evaluation());
        model.addAttribute("courses", courses);
        model.addAttribute("questions", questionService.findAllQuestions());
        return "evaluation/create";
    }

    @RequestMapping(value = "/evaluations/create-evaluation", method = RequestMethod.POST)
    public String createEvaluation(Evaluation evaluation){
        evaluationService.save(evaluation);
        return String.format("redirect:/evaluations/%s/evaluation-page", evaluation.getId());
    }

    @RequestMapping("/questions/{evaluationId}/question-form")
    public String questionForm(@PathVariable Long evaluationId, Model model){
        Evaluation evaluation = evaluationService.findEvaluationById(evaluationId);
        Question question = new Question();
//        question.addEvaluation(evaluation);
        question.setEvaluation(evaluation);
//        evaluation.addQuestion(question);
        model.addAttribute("question", question);
        return "question/create";
    }

    @RequestMapping(value = "/questions/create-question", method = RequestMethod.POST)
    public String createQuestion(Question question){
        question.getAnswers().remove(0);
//        Evaluation evaluation = question.getEvaluations().get(0);
        Evaluation evaluation = question.getEvaluation();
        evaluation.addQuestion(question);
        questionService.save(question);
        return String.format("redirect:/questions/%s/correct-answer-choice-page", question.getId());
    }

    @RequestMapping("/questions/{questionId}/correct-answer-choice-page")
    public String correctAnswerChoicePage(@PathVariable Long questionId, Model model){
        Question question = questionService.findQuestionById(questionId);
        model.addAttribute("question", question);
        return "question/answer";
    }

    @RequestMapping(value = "/questions/choose-correct-answer", method = RequestMethod.POST)
    public String chooseCorrectAnswer(Question question){
//        Evaluation evaluation = question.getEvaluations().get(0);
        Evaluation evaluation = question.getEvaluation();
        questionService.save(question);
        evaluation.addCorrectAnswer(question.getCorrectAnswer());
        evaluationService.save(evaluation);

        return String.format("redirect:/evaluations/%s/evaluation-page", evaluation.getId());
    }

    @RequestMapping(value = "/questions/{questionId}/delete-question", method = RequestMethod.POST)
    public String deleteQuestion(@PathVariable Long questionId){
        Question question = questionService.findQuestionById(questionId);
        Evaluation evaluation = question.getEvaluation();
        List<Answer> answers = question.getAnswers();

        for(Answer answer : answers){
            evaluation.getCorrectAnswers().remove(answer);
        }

        questionService.delete(question);

        return String.format("redirect:/evaluations/%s/evaluation-page", evaluation.getId());
    }

    @RequestMapping("/questions/{questionId}/question-edit-form")
    public String editQuestionForm(@PathVariable Long questionId, Model model){
        Question question = questionService.findQuestionById(questionId);
        model.addAttribute("question", question);
        return "question/edit";
    }

    @RequestMapping(value = "/questions/edit-question", method = RequestMethod.POST)
    public String editQuestion(Question question){
        questionService.save(question);

        return String.format("redirect:/evaluations/%s/evaluation-page", question.getEvaluation().getId());
    }

}
