package com.naveen.learningnavigator.controller;

import com.naveen.learningnavigator.dto.AddSubjectDto;
import com.naveen.learningnavigator.entity.Subject;
import com.naveen.learningnavigator.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/register")
    public ResponseEntity<Subject> registerSubject(@RequestBody AddSubjectDto subjectDto){
        Subject subject = subjectService.addSubject(subjectDto);
        return  new ResponseEntity<>(subject, HttpStatus.CREATED);
    }
}
