package com.naveen.learningnavigator.service;

import com.naveen.learningnavigator.dto.AddExamDto;
import com.naveen.learningnavigator.entity.Exam;

import java.util.List;

public interface IExamService {
    Exam addExam(AddExamDto exam);
    List<Exam> getAllExams();
}
