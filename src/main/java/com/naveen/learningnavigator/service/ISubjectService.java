package com.naveen.learningnavigator.service;

import com.naveen.learningnavigator.dto.AddSubjectDto;
import com.naveen.learningnavigator.entity.Subject;

import java.util.List;

public interface ISubjectService {
    Subject addSubject(AddSubjectDto subject);
    List<Subject> getSubjects();
}
