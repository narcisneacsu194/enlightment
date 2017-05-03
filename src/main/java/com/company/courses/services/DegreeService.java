package com.company.courses.services;

import com.company.courses.model.Degree;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DegreeService {
    List<Degree> findAllDegrees();
    Degree findDegreeById(Long degreeId);
    void save(Degree degree, MultipartFile file);
    void delete(Degree degree);
}
