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

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

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
        Student student = generateStudent();
        Student created = studentService.saveStudent(student);
        studentService.getStudentById(student.getId());
    }

    @Test
    public void shouldUpdateStudent() {
    }

    @Test
    public void shouldFindStudentByStudentGroup() {

    }
}
