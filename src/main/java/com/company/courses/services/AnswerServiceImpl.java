package com.company.courses.services;

import com.company.courses.dao.AnswerDao;
import com.company.courses.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService{
    @Autowired
    private AnswerDao answerDao;

    @Override
    @SuppressWarnings("unchecked")
    public List<Answer> findAllAnswers() {
        return (List)answerDao.findAll();
    }

    @Override
    public Answer findAnswerById(Long answerId) {
        return answerDao.findOne(answerId);
    }

    @Override
    public void save(Answer answer) {
        answerDao.save(answer);
    }

    @Override
    public void delete(Answer answer) {
        answerDao.delete(answer);
    }
}
