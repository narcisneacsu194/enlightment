package com.company.courses.services;

import com.company.courses.dao.AchievementDao;
import com.company.courses.model.Achievement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService{
    @Autowired
    private AchievementDao achievementDao;

    @Override
    @SuppressWarnings("unchecked")
    public List<Achievement> findAllAchievements() {
        return (List)achievementDao.findAll();
    }

    @Override
    public Achievement findAchievementById(Long achievementId) {
        return achievementDao.findOne(achievementId);
    }

    @Override
    public void save(Achievement achievement, MultipartFile file) {
        try {
            achievement.setBadge(file.getBytes());
            achievementDao.save(achievement);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Override
    public void delete(Achievement achievement) {
        achievementDao.delete(achievement);
    }
}
