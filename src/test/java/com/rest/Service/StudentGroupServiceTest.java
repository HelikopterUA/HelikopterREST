package com.rest.Service;

import com.rest.Model.StudentGroup;
import com.rest.Repository.StudentGroupRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentGroupServiceTest {

    @Mock
    private StudentGroupRepository studentGroupRepository;

    @InjectMocks
    private StudentGroupServiceImpl studentGroupService;

    @Test
    public void shouldCreateGroup(){
        StudentGroup studentGroup = new StudentGroup("2123");
        studentGroupRepository.save(studentGroup);
    }

}
