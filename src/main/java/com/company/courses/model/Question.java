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

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "question_correct_answer",
//            joinColumns = @JoinColumn(name = "question_id"),
//            inverseJoinColumns = @JoinColumn(name = "answer_id"))
//    private List<Answer> correctQuestionAnswers = new ArrayList<>();

    @ManyToOne
    private Answer answer;

    @ManyToMany(mappedBy = "questions")
    private List<Evaluation> evaluations = new ArrayList<>();

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

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public void addEvaluation(Evaluation evaluation){
        this.evaluations.add(evaluation);
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

//    public List<Answer> getCorrectQuestionAnswers() {
//        return correctQuestionAnswers;
//    }
//
//    public void setCorrectQuestionAnswers(List<Answer> correctQuestionAnswers) {
//        this.correctQuestionAnswers = correctQuestionAnswers;
//    }
//
//    public void addCorrectQuestionAnswer(Answer answer){
//        correctQuestionAnswers.add(answer);
//    }
}
