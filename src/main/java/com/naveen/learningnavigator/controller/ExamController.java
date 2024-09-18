package com.naveen.learningnavigator.controller;

import com.naveen.learningnavigator.dto.AddExamDto;
import com.naveen.learningnavigator.entity.Exam;
import com.naveen.learningnavigator.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exam")
public class ExamController {

    @Autowired
    private ExamService service;

    @PostMapping("/register")
    public ResponseEntity<Exam> registerExam(@RequestBody AddExamDto examDto){
        Exam exam = service.addExam(examDto);
        return new ResponseEntity<>(exam, HttpStatus.CREATED);
    }
}
