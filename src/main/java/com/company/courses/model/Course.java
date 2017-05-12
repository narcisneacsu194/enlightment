package com.company.courses.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 10000)
    private String description;

    @Lob
    private byte[] image;

    private String difficulty;

    @OneToOne(cascade = CascadeType.MERGE)
    private Achievement achievement;

    @OneToMany(mappedBy = "course", cascade = CascadeType.MERGE)
    private List<Chapter> chapters = new ArrayList<>();

//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
//    private List<Evaluation> evaluations = new ArrayList<>();
    @OneToOne
    private Evaluation evaluation;

    @ManyToOne(targetEntity = Subject.class)
    private Subject subject;

    @ManyToOne
    private User teacher;

    public Course(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public void addChapter(Chapter chapter){
        this.chapters.add(chapter);
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }
}
