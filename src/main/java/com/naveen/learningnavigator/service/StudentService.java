package com.naveen.learningnavigator.service;

import com.naveen.learningnavigator.dto.AddStudentDto;
import com.naveen.learningnavigator.entity.Student;
import com.naveen.learningnavigator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private StudentRepository repository;

    protected Student saveStudent(Student student){
        return repository.save(student);
    }

    protected Student getStudent(Long studentId){
        Optional<Student> student = repository.findById(studentId);
        return student.orElseThrow();
    }

    @Override
    public Student registerStudent(AddStudentDto student) {
        Student studentEntity = new Student();
        studentEntity.setStudentId(student.getStudentId());
        studentEntity.setStudentName(student.getStudentName());

        return saveStudent(studentEntity);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

}
