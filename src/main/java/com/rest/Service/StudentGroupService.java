package com.rest.Service;

import com.rest.Model.Student;
import com.rest.Model.StudentGroup;

import java.util.List;

public interface StudentGroupService {
    List<StudentGroup> getAllGroup();
    StudentGroup saveStudentGroup(StudentGroup studentGroup);
    StudentGroup updateStudentGroup(Long id, StudentGroup studentGroup);
    StudentGroup findByName(String name);
}
