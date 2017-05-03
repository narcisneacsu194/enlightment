package com.company.courses.services;

import com.company.courses.model.Subject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SubjectService {
    List<Subject> findAllSubjects();
    Subject findSubjectById(Long subjectId);
    void save(Subject subject, MultipartFile file);
    void delete(Subject subject);
}
