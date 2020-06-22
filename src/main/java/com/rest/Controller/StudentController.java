package com.rest.Controller;

import com.rest.Model.Student;
import com.rest.Repository.StudentRepository;
import com.rest.Service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping()
    public Student createNewStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @PutMapping("{id}")
    public Student UpdateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") Student student){
        studentService.deleteStudent(student);
    }
}
