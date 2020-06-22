package com.rest.Controller;

import com.rest.Model.Student;
import com.rest.Model.StudentGroup;
import com.rest.Service.StudentGroupService;
import com.rest.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("group")
public class StudentGroupController {
    @Autowired
    private StudentGroupService studentGroupService;

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentGroup> getAllStudentGroup(){
        return studentGroupService.getAllGroup();
    }

    @GetMapping("{name}")
    List<Student> getStudentByGroupName(@PathVariable("name") String name){
        StudentGroup studentGroup = studentGroupService.findByName(name);
        return studentService.getStudentsByGroupId(studentGroup.getId());
    }

    @PostMapping()
    public StudentGroup createStudentGroup(@RequestBody StudentGroup studentGroup){
        return studentGroupService.saveStudentGroup(studentGroup);
    }

    @PutMapping("{id}")
    public StudentGroup updateStudentGroup(@PathVariable("id") Long id, @RequestBody StudentGroup studentGroup){
        return studentGroupService.updateStudentGroup(id, studentGroup);
    }
}
