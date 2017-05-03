package com.company.courses.services;

import com.company.courses.dao.AchievementDao;
import com.company.courses.model.Achievement;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class AchievementServiceTest {

    @Mock
    private AchievementDao achievementDao;

    @InjectMocks
    private AchievementService service = new AchievementServiceImpl();

    @Test
    public void findAllAchievements() throws Exception {
        Achievement achievement1 = new Achievement();
        Achievement achievement2 = new Achievement();

        List<Achievement> achievements = Arrays.asList(
                achievement1,
                achievement2
        );

        when(achievementDao.findAll()).thenReturn(achievements);

        Assert.assertEquals(2, service.findAllAchievements().size());

        verify(achievementDao).findAll();
    }

    @Test
    public void findAchievementById() throws Exception {
        Achievement achievement = new Achievement();
        achievement.setName("Random Name");
        when(achievementDao.findOne(1L)).thenReturn(
                achievement
        );

        Assert.assertEquals(achievement, service.findAchievementById(1L));

        verify(achievementDao).findOne(1L);


    }

}