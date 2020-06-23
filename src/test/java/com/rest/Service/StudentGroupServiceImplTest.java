package com.rest.Service;

import com.rest.Model.Student;
import com.rest.Model.StudentGroup;
import com.rest.Repository.StudentGroupRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StudentGroupServiceImplTest {

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
        Assertions.assertThat(studentGroup.getId()).isNotEqualTo(null);
    }

    @Test
    public void shouldFindAllGroup(){
        StudentGroup studentGroup1 = generateGroup();
        StudentGroup studentGroup2 = generateGroup();
        when(studentGroupRepository.findAll()).thenReturn(List.of(studentGroup1, studentGroup2));
        List<StudentGroup> groups = studentGroupService.getAllGroup();
        Assertions.assertThat(groups.size()).isEqualTo(2);
    }
}
