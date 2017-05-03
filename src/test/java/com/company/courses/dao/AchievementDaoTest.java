package com.company.courses.dao;

import com.company.courses.model.Achievement;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

@RunWith(value = SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
properties = "spring.datasource.url = jdbc:h2:./database/test-AchievementDaoTest-achievements;DB_CLOSE_ON_EXIT=FALSE")
public class AchievementDaoTest {
    @Autowired
    private AchievementDao achievementDao;

    @Test
    public void findAll_ShouldReturnAllAchievements() throws Exception{
        Assert.assertThat(achievementDao.findAll(), hasSize(1));
    }

    @Test
    public void findOne_ShouldReturnNull() throws Exception{
        Assert.assertThat(achievementDao.findOne(10L), nullValue(Achievement.class));
    }

    @Test
    public void findOne_ShouldFindOneAchievement() throws Exception{
        Assert.assertThat(achievementDao.findOne(1L), notNullValue(Achievement.class));
    }

    @Test
    public void save_ShouldSaveAchievementIntoDatabase() throws Exception{
        Achievement achievement = new Achievement();
        achievement.setName("Random Name 2");
        achievement.setDescription("Random Description 2");
        achievementDao.save(achievement);
        Achievement achievement2 = achievementDao.findOne(achievement.getId());

        Assert.assertThat(achievementDao.findOne(achievement.getId()), notNullValue(Achievement.class));
        Assert.assertEquals(achievement.getName(), achievement2.getName());
        Assert.assertEquals(achievement.getDescription(), achievement2.getDescription());
        Assert.assertThat(achievementDao.findAll(), hasSize(2));

        achievementDao.delete(achievement);
    }

    @Test
    public void save_ShouldSaveAchievementListIntoDatabase() throws Exception{
        Achievement achievement1 = new Achievement();
        achievement1.setName("Random Name 1");
        achievement1.setDescription("Random Description 1");
        Achievement achievement2 = new Achievement();
        achievement2.setName("Random Name 2");
        achievement2.setDescription("Random Description 2");

        List<Achievement> achievements = new ArrayList<>();
        achievements.add(achievement1);achievements.add(achievement2);

        achievementDao.save(achievements);

        Assert.assertThat(achievementDao.findAll(), hasSize(3));
        Assert.assertThat(achievementDao.findOne(achievement1.getId()), notNullValue());
        Assert.assertThat(achievementDao.findOne(achievement2.getId()), notNullValue());

        achievementDao.delete(achievement1);
        achievementDao.delete(achievement2);
    }

    @Test
    public void delete_ShouldDeleteAchievementFromDatabase() throws Exception{
        Achievement achievement = new Achievement();
        achievement.setName("Random Name 2");
        achievement.setDescription("Random Description 2");
        achievementDao.save(achievement);

        Assert.assertThat(achievementDao.findOne(achievement.getId()),
                notNullValue(Achievement.class));

        Long achievementId = achievement.getId();
        achievementDao.delete(achievement);

        Assert.assertThat(achievementDao.findOne(achievementId),
                nullValue(Achievement.class));
    }

    @Test
    public void delete_ShouldDeleteAchievementByIdFromDatabase() throws Exception{
        Achievement achievement = new Achievement();
        achievementDao.save(achievement);

        Assert.assertThat(achievementDao.findOne(achievement.getId()),
                notNullValue(Achievement.class));

        Long achievementId = achievement.getId();
        achievementDao.delete(achievement.getId());

        Assert.assertThat(achievementDao.findOne(achievementId),
                nullValue(Achievement.class));

    }

    @Test
    public void delete_ShouldDeleteAchievementListFromDatabase() throws Exception{
        Achievement achievement1 = new Achievement();
        Achievement achievement2 = new Achievement();

        List<Achievement> achievements = new ArrayList<>();
        achievements.add(achievement1);
        achievements.add(achievement2);
        achievementDao.save(achievements);

        Assert.assertThat(achievementDao.findAll(), hasSize(3));

        achievementDao.delete(achievements);

        Assert.assertThat(achievementDao.findAll(), hasSize(1));
    }

    @Test
    public void exists_ShouldReturnTrue() throws Exception{
        Assert.assertEquals(true, achievementDao.exists(1L));
    }

    @Test
    public void exists_ShouldReturnFalse() throws Exception{
        Assert.assertEquals(false, achievementDao.exists(2L));
    }

}