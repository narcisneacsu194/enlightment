package com.company.courses.services;

import com.company.courses.dao.SubjectDao;
import com.company.courses.model.Subject;
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
public class SubjectServiceTest {

    @Mock
    private SubjectDao subjectDao;

    @InjectMocks
    private SubjectService service = new SubjectServiceImpl();

    @Test
    public void findAllSubjects() throws Exception {
        Subject subject1 = new Subject();
        Subject subject2 = new Subject();

        List<Subject> subjects = Arrays.asList(
                subject1,
                subject2
        );

        when(subjectDao.findAll()).thenReturn(subjects);

        Assert.assertEquals(2, service.findAllSubjects().size());

        verify(subjectDao).findAll();
    }

    @Test
    public void findSubjectById() throws Exception {
        Subject subject = new Subject();
        subject.setName("Random Name");
        when(subjectDao.findOne(1L)).thenReturn(
                subject
        );

        Assert.assertEquals(subject, service.findSubjectById(1L));

        verify(subjectDao).findOne(1L);
    }

}