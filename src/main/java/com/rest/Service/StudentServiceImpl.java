package com.rest.Service;

import com.rest.Model.Student;
import com.rest.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    String chars = "!@#$%^&*()_+?><{}|\\=-`~1234567890";

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        if (CollectionUtils.isEmpty(students)) {
            throw new IllegalStateException("database is empty");
        }
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    @Override
    public List<Student> getStudentsByGroupId(Long id) {
        List<Student> students = studentRepository.findByStudentGroupId(id);
        if (CollectionUtils.isEmpty(students)) {
            throw new IllegalStateException("Group with such Id is not found");
        }
        return students;
    }

    @Override
    public Student saveStudent(Student student) {
        Student find = studentRepository.findByEmail(student.getEmail());
        if (find != null) {
            throw new IllegalStateException("Student with such email is already exists");
        }

        if (!student.getEmail().contains("@") || !student.getEmail().contains(".")) {
            throw new IllegalStateException("Bad Email");
        }

        if (student.getEmail().length() <= 6) {
            throw new IllegalStateException("Email too short");
        }

        for (int i = 0; i < chars.length(); i++) {
            char j = chars.charAt(i);
            String symbol = String.valueOf(j);

            if (student.getFirstName().contains(symbol)) {
                throw new IllegalStateException("First Name contains special characters or numbers");
            }
            if (student.getLastName().contains(symbol)) {
                throw new IllegalStateException("Last Name contains special characters or numbers");
            }
        }

        if (student.getFirstName().length() <= 1) {
            throw new IllegalStateException("First Name too short");
        }

        if (student.getLastName().length() <= 1) {
            throw new IllegalStateException("Last Name too short");
        }

        if (student.getRatingScore() < 0 || student.getRatingScore() > 100) {
            throw new IllegalStateException("Bad rating score");
        }
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student newStudent = studentRepository.findById(id).get();
        if (student.getFirstName() != null) {
            for (int i = 0; i < chars.length(); i++) {
                char j = chars.charAt(i);
                String symbol = String.valueOf(j);
                if (student.getFirstName().contains(symbol)) {
                    throw new IllegalStateException("First Name contains special characters or numbers");
                } else if (student.getFirstName().length() <= 1) {
                    throw new IllegalStateException("First Name too short");
                }
            }
            newStudent.setFirstName(student.getFirstName());
        }
        if (student.getLastName() != null) {
            for (int i = 0; i < chars.length(); i++) {
                char j = chars.charAt(i);
                String symbol = String.valueOf(j);
                if (student.getLastName().contains(symbol)) {
                    throw new IllegalStateException("Last Name contains special characters or numbers");
                } else if (student.getFirstName().length() <= 1) {
                    throw new IllegalStateException("Last Name too short");
                }
            }
            newStudent.setLastName(student.getLastName());
        }
        if (student.getAddress() != null) {
            newStudent.setAddress(student.getAddress());
        }
        if (student.getEmail() != null) {
            Student find = studentRepository.findByEmail(student.getEmail());
            if (find != null && !id.equals(find.getId())) {
                throw new IllegalStateException("Student with such email is already exists");
            } else if (student.getEmail().length() <= 6) {
                throw new IllegalStateException("Email too short");
            } else if (!student.getEmail().contains("@") || !student.getEmail().contains(".")) {
                throw new IllegalStateException("Bad Email");
            }
            newStudent.setEmail(student.getEmail());
        }
        if (student.getStudentGroup() != null) {
            newStudent.setStudentGroup(student.getStudentGroup());
        }
        if (student.getRatingScore() != 0) {
            if (student.getRatingScore() < 0 || student.getRatingScore() > 100) {
                throw new IllegalStateException("Bad rating score");
            }
            newStudent.setRatingScore(student.getRatingScore());
        }
        studentRepository.save(newStudent);
        return newStudent;
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

}
