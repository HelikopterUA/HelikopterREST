package com.rest.Service;

import com.rest.Model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    List<Student> getStudentsByGroupId(Long id);

    Student saveStudent(Student student);

    Student updateStudent(Long id,Student student);

    void deleteStudent(Student student);
}
