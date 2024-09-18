package com.naveen.learningnavigator.controller;

import com.naveen.learningnavigator.dto.AddStudentDto;
import com.naveen.learningnavigator.entity.Student;
import com.naveen.learningnavigator.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody AddStudentDto studentDto){
        Student student = service.registerStudent(studentDto);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

}
