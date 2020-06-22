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

    public StudentGroup generateGroup(){
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setId(1);
        studentGroup.setStudentGroupName("КН-3");
        return studentGroup;
    }

    @Test
    public void shouldCreateGroup(){
        StudentGroup studentGroup = generateGroup();
        StudentGroup studentGroup1 = studentGroupService.saveStudentGroup(studentGroup);
    }

}
