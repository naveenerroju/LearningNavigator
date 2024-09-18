package com.naveen.learningnavigator.service;

import com.naveen.learningnavigator.dto.AddExamDto;
import com.naveen.learningnavigator.entity.Exam;
import com.naveen.learningnavigator.repository.ExamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService implements IExamService{

    @Autowired
    private ExamRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private SubjectService subjectService;

    @Override
    public Exam addExam(AddExamDto exam) {
        Exam examEntity = new Exam();
        examEntity.setExamId(exam.getExamId());
        examEntity.setSubject(subjectService.getSubject(exam.getSubjectId()));

        return repository.save(examEntity);
    }

    @Override
    public List<Exam> getAllExams() {
        return repository.findAll();
    }

    protected Exam getExam(Long examId){
        Optional<Exam> exam = repository.findById(examId);
        return exam.orElseThrow();
    }
}
