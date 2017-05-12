package com.company.courses.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private boolean isPassed;

    private int percentage;

    @OneToMany(mappedBy = "evaluation", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

//    @ManyToOne
//    private Course course;

    @OneToOne
    private Course course;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "evaluation_userAnswer",
    joinColumns = @JoinColumn(name = "evaluation_id"),
            inverseJoinColumns = @JoinColumn(name = "user_answer_id"))
    private List<Answer> userAnswers = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "evaluation_correctAnswer",
//    joinColumns = @JoinColumn(name = "evaluation_id"),
//    inverseJoinColumns = @JoinColumn(name = "correct_answer_id"))
    private List<Answer> correctAnswers = new ArrayList<>();

    public Evaluation(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Answer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<Answer> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public void addUserAnswer(Answer answer){
        userAnswers.add(answer);
    }

    public List<Answer> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(List<Answer> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public void addCorrectAnswer(Answer answer){
        correctAnswers.add(answer);
    }

    public void removeCorrectAnswer(Answer answer){
        correctAnswers.remove(answer);
    }

//    public boolean isPassed() {
//        return isPassed;
//    }
//
//    public void setPassed(boolean passed) {
//        isPassed = passed;
//    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
