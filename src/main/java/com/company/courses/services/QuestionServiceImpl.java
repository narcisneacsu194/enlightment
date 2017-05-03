package com.company.courses.services;

import com.company.courses.dao.QuestionDao;
import com.company.courses.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionDao questionDao;

    @Override
    @SuppressWarnings("unchecked")
    public List<Question> findAllQuestions() {
        return (List)questionDao.findAll();
    }

    @Override
    public Question findQuestionById(Long questionId) {
        return questionDao.findOne(questionId);
    }

    @Override
    public void save(Question question) {
        questionDao.save(question);
    }

    @Override
    public void delete(Question question) {
        questionDao.delete(question);
    }
}
