package com.company.courses.services;

import com.company.courses.dao.SubjectDao;
import com.company.courses.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired
    private SubjectDao subjectDao;

    @Override
    @SuppressWarnings("unchecked")
    public List<Subject> findAllSubjects() {
        return (List)subjectDao.findAll();
    }

    @Override
    public Subject findSubjectById(Long subjectId) {
        return subjectDao.findOne(subjectId);
    }

    @Override
    public void save(Subject subject, MultipartFile file) {
        try {
            subject.setImage(file.getBytes());
            subjectDao.save(subject);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Override
    public void delete(Subject subject) {
        subjectDao.delete(subject);
    }
}
