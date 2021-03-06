package com.company.courses.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "question_answer",
    joinColumns = @JoinColumn(name = "question_id"),
    inverseJoinColumns = @JoinColumn(name = "answer_id"))
    private List<Answer> answers = new ArrayList<>();

    @ManyToOne
    private Answer correctAnswer;

    @ManyToOne
    private Evaluation evaluation;

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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer){
        this.answers.add(answer);
    }

//    public List<Evaluation> getEvaluations() {
//        return evaluations;
//    }
//
//    public void setEvaluations(List<Evaluation> evaluations) {
//        this.evaluations = evaluations;
//    }
//
//    public void addEvaluation(Evaluation evaluation){
//        this.evaluations.add(evaluation);
//    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

//    public List<Answer> getCorrectQuestionAnswers() {
//        return correctQuestionAnswers;
//    }
//
//    public void setCorrectQuestionAnswers(List<Answer> correctQuestionAnswers) {
//        this.correctQuestionAnswers = correctQuestionAnswers;
//    }
//
//    public void addCorrectQuestionAnswer(Answer correctAnswer){
//        correctQuestionAnswers.add(correctAnswer);
//    }
}
