package com.company.courses.services;

import com.company.courses.model.Achievement;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AchievementService {
    List<Achievement> findAllAchievements();
    Achievement findAchievementById(Long achievementId);
    void save(Achievement achievement, MultipartFile file);
    void delete(Achievement achievement);
}
