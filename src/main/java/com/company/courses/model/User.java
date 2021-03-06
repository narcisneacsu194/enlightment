package com.company.courses.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails{
    public static final PasswordEncoder PASSWORD_ENCODER =
            new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(length = 100)
    @JsonIgnore
    private String password;

    @Column(length = 100)
    @JsonIgnore
    private String matchingPassword;

    private String firstName; // mandatory

    private String lastName; // mandatory

    private String description; // not mandatory

    private String location; // not mandatory

    private Instant dateOfRegistration; // not mandatory

    private String email; // mandatory

    private String githubUrl; // not mandatory

    private String linkedinUrl; // not mandatory

    @Lob
    private byte[] avatar; // not mandatory

    @Column(nullable = false)
    private boolean enabled;

    private boolean admin;

    @OneToOne
    @JoinColumn(name = "role_id")
    @JsonIgnore
    private Role role;

    @ManyToMany
    @JoinTable(name = "user_achievement", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "achievement_id"))
    private List<Achievement> achievements = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_degree", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "degree_id"))
    private List<Degree> degrees = new ArrayList<>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Subject> createdSubjects = new ArrayList<>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Course> createdCourses = new ArrayList<>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Achievement> createdAchievements = new ArrayList<>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Degree> createdDegrees = new ArrayList<>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Chapter> createdChapters = new ArrayList<>();

    public User(){
        id = null;
        username = null;
        password = null;
        role = null;
    }

    public User(String username, String password, boolean enabled){
        this.username = username;
        setPassword(password);
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setRole(Role role){
        this.role = role;
    }

    public Role getRole(){
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Instant getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Instant dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public void encodePasswords(){
        password = PASSWORD_ENCODER.encode(password);
        matchingPassword = PASSWORD_ENCODER.encode(matchingPassword);
    }

    public void encodePassword(){
        password = PASSWORD_ENCODER.encode(password);
    }

    public void encodeMatchingPassword(){
        matchingPassword = PASSWORD_ENCODER.encode(matchingPassword);
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    public void addAchievement(Achievement achievement){
        achievements.add(achievement);
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
        degrees.add(degree);
    }

    public void removeDegree(Degree degree){
        degrees.remove(degree);
    }

    public List<Subject> getCreatedSubjects() {
        return createdSubjects;
    }

    public void setCreatedSubjects(List<Subject> createdSubjects) {
        this.createdSubjects = createdSubjects;
    }

    public void addCreatedSubject(Subject subject){
        createdSubjects.add(subject);
    }

    public void removeCreatedSubject(Subject subject){
        createdSubjects.remove(subject);
    }

    public List<Course> getCreatedCourses() {
        return createdCourses;
    }

    public void setCreatedCourses(List<Course> createdCourses) {
        this.createdCourses = createdCourses;
    }

    public void addCreatedCourse(Course course){
        createdCourses.add(course);
    }

    public void removeCreatedCourse(Course course){
        createdCourses.remove(course);
    }

    public List<Achievement> getCreatedAchievements() {
        return createdAchievements;
    }

    public void setCreatedAchievements(List<Achievement> createdAchievements) {
        this.createdAchievements = createdAchievements;
    }

    public void addCreatedAchievement(Achievement achievement){
        createdAchievements.add(achievement);
    }

    public void removeCreatedAchievement(Achievement achievement){
        createdAchievements.remove(achievement);
    }

    public List<Degree> getCreatedDegrees() {
        return createdDegrees;
    }

    public void setCreatedDegrees(List<Degree> createdDegrees) {
        this.createdDegrees = createdDegrees;
    }

    public void addCreatedDegree(Degree degree){
        createdDegrees.add(degree);
    }

    public void removeCreatedDegree(Degree degree){
        createdDegrees.remove(degree);
    }

    public List<Chapter> getCreatedChapters() {
        return createdChapters;
    }

    public void setCreatedChapters(List<Chapter> createdChapters) {
        this.createdChapters = createdChapters;
    }

    public void addCreatedChapter(Chapter chapter){
        createdChapters.add(chapter);
    }

    public void removeCreatedChapter(Chapter chapter){
        createdChapters.remove(chapter);
    }
}
