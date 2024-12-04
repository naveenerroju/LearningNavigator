package com.naveen.learningnavigator.controller;

import com.naveen.learningnavigator.dto.AddSubjectDto;
import com.naveen.learningnavigator.entity.Student;
import com.naveen.learningnavigator.entity.Subject;
import com.naveen.learningnavigator.service.StudentEnrollmentService;
import com.naveen.learningnavigator.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentEnrollmentService studentEnrollmentService;

    @PostMapping("/register")
    public ResponseEntity<Subject> registerSubject(@RequestBody AddSubjectDto subjectDto){
        Subject subject = subjectService.addSubject(subjectDto);
        return  new ResponseEntity<>(subject, HttpStatus.CREATED);
    }

    @PostMapping("/{subjectId}/{studentId}")
    public ResponseEntity<Student> enrollSubject(
            @PathVariable(name = "subjectId") Long subjectId,
            @PathVariable(name = "studentId") Long studentId
    ){
        Student student = studentEnrollmentService.enrollSubject(studentId, subjectId);
        return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
    }

}
