package com.naveen.learningnavigator.service;

import com.naveen.learningnavigator.dto.AddSubjectDto;
import com.naveen.learningnavigator.entity.Subject;
import com.naveen.learningnavigator.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements ISubjectService{

    @Autowired
    private SubjectRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Subject addSubject(AddSubjectDto subject) {
        Subject subjectEntity =modelMapper.map(subject, Subject.class);
        return repository.save(subjectEntity);
    }

    @Override
    public List<Subject> getSubjects() {
        return repository.findAll();
    }

    protected Subject getSubject(Long subjectId){
        Optional<Subject> subject = repository.findById(subjectId);
        return subject.orElseThrow(RuntimeException::new);
    }



}
