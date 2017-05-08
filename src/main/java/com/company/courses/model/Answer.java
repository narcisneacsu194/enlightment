package com.company.courses.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "answers")
    private List<Question> questions = new ArrayList<>();

    @ManyToMany(mappedBy = "userAnswers")
    private List<Evaluation> userAnswersEvaluations = new ArrayList<>();

    @ManyToOne
    private Evaluation evaluation;
//    private List<Evaluation> correctAnswersEvaluations = new ArrayList<>();

//    @ManyToMany( cascade = CascadeType.ALL)
//    @JoinTable(name = "question_correct_answer",
//            joinColumns = @JoinColumn(name = "answer_id"),
//            inverseJoinColumns = @JoinColumn(name = "question_id"))
//    private List<Question> correctAnswersQuestions = new ArrayList<>();

    @OneToMany
    private List<Question> correctAnswerToQuestions = new ArrayList<>();

    public Answer(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question){
        this.questions.add(question);
    }

    public List<Evaluation> getUserAnswersEvaluations() {
        return userAnswersEvaluations;
    }

    public void setUserAnswersEvaluations(List<Evaluation> evaluation1) {
        this.userAnswersEvaluations = evaluation1;
    }

    public void addUserAnswersEvaluation(Evaluation evaluation){
        userAnswersEvaluations.add(evaluation);
    }

//    public List<Evaluation> getCorrectAnswersEvaluations() {
//        return correctAnswersEvaluations;
//    }
//
//    public void setCorrectAnswersEvaluations(List<Evaluation> correctAnswersEvaluations) {
//        this.correctAnswersEvaluations = correctAnswersEvaluations;
//    }
//
//    public void addCorrectAnswersEvaluations(Evaluation evaluation){
//        correctAnswersEvaluations.add(evaluation);
//    }

    public List<Question> getCorrectAnswerToQuestions() {
        return correctAnswerToQuestions;
    }

    public void setCorrectAnswerToQuestions(List<Question> correctAnswerToQuestions) {
        this.correctAnswerToQuestions = correctAnswerToQuestions;
    }

    public void addCorrectAnswerToQuestion(Question question){
        correctAnswerToQuestions.add(question);
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }


//    public List<Question> getCorrectAnswersQuestions() {
//        return correctAnswersQuestions;
//    }
//
//    public void setCorrectAnswersQuestions(List<Question> correctAnswersQuestions) {
//        this.correctAnswersQuestions = correctAnswersQuestions;
//    }
//
//    public void addCorrectAnswersQuestion(Question question){
//        correctAnswersQuestions.add(question);
//    }
}
