package com.company.courses.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 10000)
    private String description;

    @Lob
    private byte[] image;

    public Subject(){

    }

    @OneToMany(mappedBy = "subject")
    private List<Achievement> achievements = new ArrayList<>();

    @OneToMany(mappedBy = "subject")
    private List<Degree> degrees = new ArrayList<>();

    @OneToMany(mappedBy = "subject", cascade = CascadeType.PERSIST)
    private List<Course> courses = new ArrayList<>();

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

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    public void addAchievement(Achievement achievement){
        this.achievements.add(achievement);
    }

    public void removeAchievement(Achievement achievement){
        achievements.remove(achievement);
    }

    public List<Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<Degree> degrees) {
        this.degrees = degrees;
    }

    public void addDegree(Degree degree){
        this.degrees.add(degree);
    }

    public void removeDegree(Degree degree){
        degrees.remove(degree);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
    }
}
