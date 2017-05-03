package com.company.courses.services;

import com.company.courses.model.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> findAllAnswers();
    Answer findAnswerById(Long answerId);
    void save(Answer answer);
    void delete(Answer answer);
}
