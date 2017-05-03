package com.company.courses.services;

import com.company.courses.dao.EvaluationDao;
import com.company.courses.model.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    private EvaluationDao evaluationDao;

    @Override
    @SuppressWarnings("unchecked")
    public List<Evaluation> findAllEvaluations() {
        return (List) evaluationDao.findAll();
    }

    @Override
    public Evaluation findEvaluationById(Long testId) {
        return evaluationDao.findOne(testId);
    }

    @Override
    public void save(Evaluation evaluation) {
        evaluationDao.save(evaluation);
    }

    @Override
    public void delete(Evaluation evaluation) {
        evaluationDao.delete(evaluation);
    }
}
