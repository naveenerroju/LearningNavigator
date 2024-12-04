package com.naveen.learningnavigator.service;

import com.naveen.learningnavigator.dto.AddStudentDto;
import com.naveen.learningnavigator.entity.Student;

import java.util.List;

public interface IStudentService {
    Student registerStudent(AddStudentDto student);
    List<Student> getAllStudents();
}
