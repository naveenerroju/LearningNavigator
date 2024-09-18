package com.naveen.learningnavigator.service;

import com.naveen.learningnavigator.dto.AddStudentDto;
import com.naveen.learningnavigator.entity.Student;

public interface IStudentService {
    Student registerStudent(AddStudentDto student);
    Student enrollSubject(Long studentId, Long subjectId);
    Student enrollExam(Long studentId, Long examId);
}
