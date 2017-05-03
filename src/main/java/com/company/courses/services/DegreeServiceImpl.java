package com.company.courses.services;

import com.company.courses.dao.DegreeDao;
import com.company.courses.model.Degree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DegreeServiceImpl implements DegreeService{
    @Autowired
    private DegreeDao degreeDao;

    @Override
    @SuppressWarnings("unchecked")
    public List<Degree> findAllDegrees() {
        return (List)degreeDao.findAll();
    }

    @Override
    public Degree findDegreeById(Long degreeId) {
        return degreeDao.findOne(degreeId);
    }

    @Override
    public void save(Degree degree, MultipartFile file) {
        try {
            degree.setDiploma(file.getBytes());
            degreeDao.save(degree);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Override
    public void delete(Degree degree) {
        degreeDao.delete(degree);
    }
}
