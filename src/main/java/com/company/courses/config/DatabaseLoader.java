package com.company.courses.config;

import com.company.courses.dao.*;
import com.company.courses.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner{

    private AchievementDao achievementDao;
    private AnswerDao answerDao;
    private ChapterDao chapterDao;
    private CourseDao courseDao;
    private DegreeDao degreeDao;
    private QuestionDao questionDao;
    private SubjectDao subjectDao;
    private EvaluationDao evaluationDao;
    private UserDao userDao;
    private RoleDao roleDao;

    @Autowired
    public DatabaseLoader(UserDao userDao, RoleDao roleDao, AchievementDao achievementDao, AnswerDao answerDao, ChapterDao chapterDao,
                          CourseDao courseDao, DegreeDao degreeDao, QuestionDao questionDao,
                          SubjectDao subjectDao, EvaluationDao evaluationDao){
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.achievementDao = achievementDao;
        this.answerDao = answerDao;
        this.chapterDao = chapterDao;
        this.courseDao = courseDao;
        this.degreeDao = degreeDao;
        this.questionDao = questionDao;
        this.subjectDao = subjectDao;
        this.evaluationDao = evaluationDao;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role role = new Role();
        role.setName("ROLE_ADMIN");
        Role role2 = new Role();
        role2.setName("ROLE_USER");
        roleDao.save(role);
        roleDao.save(role2);

        byte[] bytes = extractBytes("src/main/resources/static/img/placeholder.jpg");
        List<User> users = new ArrayList<>();
        List<Subject> subjects = new ArrayList<>();
        IntStream.range(0, 6).forEach(value ->{
            User user = new User();
            user.setAdmin(true);
            user.setEmail("randomuser" + value + "@enlightment.com");
            user.setDescription("Random Description " + value);
            user.setEnabled(true);
            user.setFirstName("Random");
            user.setLastName("User " + value);
            user.setLocation("Random location " + value);
            user.setUsername("random.user" + value);
            user.setPassword("password");
            user.encodePassword();
            user.setRole(role);
            user.setGithubUrl("http://github.com/randomuser" + value);
            user.setLinkedinUrl("http://linkedin.com/randomuser" + value);
            user.setDateOfRegistration(Instant.now());
            user.setAvatar(bytes);

            users.add(user);


            Subject subject = new Subject();
            subject.setName("Subject Name " + value);
            subject.setDescription("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                    "\n" +
                    "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");
            subject.setImage(bytes);
            subject.setTeacher(user);
            user.addCreatedSubject(subject);

            subjects.add(subject);

            userDao.save(user);
            subjectDao.save(subject);

        });
        int counter = 0;
        List<Course> courses = new ArrayList<>();
        for(int i = 0;i < 6;i++){
            User user = users.get(i);
            Subject subject = subjects.get(i);

            for(int j = 0;j < 6;j++){
                Course course = new Course();
                course.setName("Course Name " + counter++);
                course.setDescription("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                        "\n" +
                        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");
                course.setDifficulty("Beginner");
                course.setImage(bytes);
                course.setSubject(subject);
                course.setTeacher(user);
                user.addCreatedCourse(course);
                subject.addCourse(course);
                courses.add(course);

                courseDao.save(course);
            }

        }

        counter = 0;
        List<Achievement> achievements = new ArrayList<>();
        for(int i = 0;i < 6;i++){
            User user = users.get(i);
            Subject subject = subjects.get(i);

            for(int j = 0;j < 6;j++){
                Achievement achievement = new Achievement();
                achievement.setName("Achievement Name " + counter++);
                achievement.setDescription("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                        "\n" +
                        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");

                achievement.setBadge(bytes);
                achievement.setPoints(5000);
                achievement.setTeacher(user);
                user.addAchievement(achievement);
                achievement.setSubject(subject);
                subject.addAchievement(achievement);
                achievements.add(achievement);
                achievementDao.save(achievement);
            }

        }

        IntStream.range(0, 36).forEach(value ->{
            Course course = courses.get(value);
            Achievement achievement = achievements.get(value);
            course.setAchievement(achievement);
            achievement.setCourse(course);

            courseDao.save(course);
            achievementDao.save(achievement);
        });

        List<Degree> degrees = new ArrayList<>();
        IntStream.range(0, 6).forEach(value ->{
            User user = users.get(value);
            Subject subject = subjects.get(value);

            Degree degree = new Degree();
            degree.setName("Degree Name " + value);
            degree.setDescription("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                    "\n" +
                    "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");
            degree.setDiploma(bytes);
            degree.setTeacher(user);
            user.addDegree(degree);
            degree.setSubject(subject);
//            subject.addDegree(degree);
            subject.setDegree(degree);
            degrees.add(degree);

            degreeDao.save(degree);
        });

        for(int i = 0;i < 36;i++){
            Course course = courses.get(i);
            Evaluation evaluation = new Evaluation();
            for(int j = 1;j <= 6;j++){
                Question question = new Question();
                question.setDescription("Question " + (i+j) + " ?");
                Answer answer1 = new Answer();
                answer1.setDescription("Answer " + (i+j+1));
                answer1.addQuestion(question);
                answer1.addCorrectAnswerToQuestion(question);
                answer1.setEvaluation(evaluation);

                Answer answer2 = new Answer();
                answer2.setDescription("Answer " + (i+j+2));
                answer2.addQuestion(question);

                Answer answer3 = new Answer();
                answer3.setDescription("Answer " + (i+j+3));
                answer3.addQuestion(question);

                Answer answer4 = new Answer();
                answer4.setDescription("Answer " + (i+j+4));
                answer4.addQuestion(question);

                question.addAnswer(answer1);question.addAnswer(answer2);
                question.addAnswer(answer3);question.addAnswer(answer4);
                question.setCorrectAnswer(answer1);

                question.setEvaluation(evaluation);
                evaluation.addQuestion(question);
                evaluation.addCorrectAnswer(answer1);
            }
            course.setEvaluation(evaluation);
            evaluation.setCourse(course);

            evaluationDao.save(evaluation);
            courseDao.save(course);
        }

        for(int i = 0;i < 36;i++){
            Course course = courses.get(i);
            User user = course.getTeacher();
            for(int j = 1;j <= 3;j++){
               Chapter chapter = new Chapter();
                chapter.setTitle("Chapter " + (i+j));
                chapter.setContent("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                        "\n" +
                        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");
                chapter.setImage(bytes);
                chapter.setCourse(course);
                course.addChapter(chapter);
                user.addCreatedChapter(chapter);
                chapter.setTeacher(user);
            }

            courseDao.save(course);
        }

        IntStream.range(6, 12).forEach(value ->{
            User user = new User();
            user.setAdmin(false);
            user.setEmail("randomuser" + value + "@enlightment.com");
            user.setDescription("Random Description " + value);
            user.setEnabled(true);
            user.setFirstName("Random");
            user.setLastName("User " + value);
            user.setLocation("Random location " + value);
            user.setUsername("random.user" + value);
            user.setPassword("password");
            user.encodePassword();
            user.setRole(role2);
            user.setGithubUrl("http://github.com/randomuser" + value);
            user.setLinkedinUrl("http://linkedin.com/randomuser" + value);
            user.setDateOfRegistration(Instant.now());
            user.setAvatar(bytes);

            Achievement achievement1 = achievements.get(value);
            Achievement achievement2 = achievements.get(value+1);
            Achievement achievement3 = achievements.get(value+2);

            Degree degree = degrees.get(value-6);

            user.addAchievement(achievement1);achievement1.addUser(user);
            user.addAchievement(achievement2);achievement2.addUser(user);
            user.addAchievement(achievement3);achievement3.addUser(user);
            user.addDegree(degree);degree.addUser(user);

            userDao.save(user);
        });
    }

    private byte[] extractBytes(String ImageName) throws IOException {
        File imgPath = new File(ImageName);
        return Files.readAllBytes(imgPath.toPath());
    }
}
