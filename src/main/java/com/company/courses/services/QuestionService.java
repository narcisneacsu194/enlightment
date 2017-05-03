package com.company.courses.services;

import com.company.courses.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAllQuestions();
    Question findQuestionById(Long questionId);
    void save(Question question);
    void delete(Question question);
}
