package com.rest.Service;

import com.rest.Model.StudentGroup;
import com.rest.Repository.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {
    @Autowired
    private StudentGroupRepository studentGroupRepository;

    String chars = "!@#$%^&*()_+?><{}|\\=`~";

    @Override
    public List<StudentGroup> getAllGroup() {
        return studentGroupRepository.findAll();
    }

    @Override
    public StudentGroup findByName(String name) {
        return studentGroupRepository.findByStudentGroupName(name);
    }

    @Override
    public StudentGroup saveStudentGroup(StudentGroup studentGroup) {
        if (studentGroup.getStudentGroupName().length() < 3) {
            throw new IllegalStateException("Student group name too short");
        }
        if (!studentGroup.getStudentGroupName().contains("-")) {
            throw new IllegalStateException("Bad student group name");
        }
        for (int i = 0; i < chars.length(); i++) {
            char j = chars.charAt(i);
            String symbol = String.valueOf(j);

            if (studentGroup.getStudentGroupName().contains(symbol)) {
                throw new IllegalStateException("Student group name contains special characters or numbers");
            }
        }
        studentGroupRepository.save(studentGroup);
        return studentGroup;
    }

    @Override
    public StudentGroup updateStudentGroup(Long id, StudentGroup studentGroup) {
        StudentGroup newStudentGroup = studentGroupRepository.findById(id).get();
        newStudentGroup.setStudentGroupName(studentGroup.getStudentGroupName());
        studentGroupRepository.save(newStudentGroup);
        return newStudentGroup;
    }
}
