package com.naveen.learningnavigator.service;

import com.naveen.learningnavigator.entity.Exam;
import com.naveen.learningnavigator.entity.Student;
import com.naveen.learningnavigator.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentEnrollmentService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ExamService examService;

    public Student enrollSubject(Long studentId, Long subjectId){
        Student student = studentService.getStudent(studentId);
        Subject subject = subjectService.getSubject(subjectId);
        student.getSubjects().add(subject);
        return studentService.saveStudent(student);
    }

    public Student enrollExam(Long studentId, Long examId){
        Student student = studentService.getStudent(studentId);
        Exam exam = examService.getExam(examId);
        student.getExams().add(exam);
        return studentService.saveStudent(student);
    }

}
