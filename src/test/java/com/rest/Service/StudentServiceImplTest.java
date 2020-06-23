package com.rest.Service;

import com.rest.Model.Address;
import com.rest.Model.Student;
import com.rest.Model.StudentGroup;
import com.rest.Repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    private Student generateStudent() {
        StudentGroup studentGroup = new StudentGroup("M-I-1");
        Address address = new Address("Ukraine", "Kiev");
        Student student = new Student();
        student.setId((long) 1);
        student.setFirstName("Ivan");
        student.setLastName("Ivanov");
        student.setEmail("helikopterua@gmail.com");
        student.setRatingScore(90);
        student.setStudentGroup(studentGroup);
        student.setAddress(address);
        return student;
    }

    @Test
    public void shouldCreateStudent() {
        Student student = generateStudent();
        Student created = studentService.saveStudent(student);
        Assertions.assertThat(created.getId()).isNotEqualTo(null);
    }

    @Test
    public void shouldFindStudentById() {
        long id = 1;
        Student student = generateStudent();
        when(studentRepository.findById(id)).thenReturn(java.util.Optional.of(student));
        Student find = studentService.getStudentById(id);
        Assertions.assertThat(find.getEmail()).isEqualTo(student.getEmail());
    }

    @Test
    public void shouldFindAllStudent() {
        Student student1 = generateStudent();
        Student student2 = generateStudent();
        when(studentRepository.findAll()).thenReturn(List.of(student1, student2));
        List<Student> students = studentService.getAllStudents();
        Assertions.assertThat(students.size()).isEqualTo(2);
    }
}
