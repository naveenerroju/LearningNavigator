package com.naveen.learningnavigator.controller;

import com.naveen.learningnavigator.dto.AddExamDto;
import com.naveen.learningnavigator.entity.Exam;
import com.naveen.learningnavigator.entity.Student;
import com.naveen.learningnavigator.service.ExamService;
import com.naveen.learningnavigator.service.StudentEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("exam")
public class ExamController {

    @Autowired
    private ExamService service;
    @Autowired
    private StudentEnrollmentService studentEnrollmentService;

    @PostMapping("/register")
    public ResponseEntity<Exam> registerExam(@RequestBody AddExamDto examDto){
        Exam exam = service.addExam(examDto);
        return new ResponseEntity<>(exam, HttpStatus.CREATED);
    }

    @PostMapping("/{examId}/{studentId}")
    public ResponseEntity<Student> enrollExam(
            @PathVariable(name = "examId") Long examId,
            @PathVariable(name = "studentId") Long studentId
    ){
        Student student = studentEnrollmentService.enrollExam(studentId, examId);
        return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
    }

}
