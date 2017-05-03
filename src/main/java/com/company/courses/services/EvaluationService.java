package com.company.courses.services;

import com.company.courses.model.Evaluation;

import java.util.List;

public interface EvaluationService {
    List<Evaluation> findAllEvaluations();
    Evaluation findEvaluationById(Long testId);
    void save(Evaluation evaluation);
    void delete(Evaluation evaluation);
}
