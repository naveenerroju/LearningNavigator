package com.naveen.learningnavigator.service;

import com.naveen.learningnavigator.dto.AddStudentDto;
import com.naveen.learningnavigator.entity.Exam;
import com.naveen.learningnavigator.entity.Student;
import com.naveen.learningnavigator.entity.Subject;
import com.naveen.learningnavigator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private StudentRepository repository;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ExamService examService;

    @Override
    public Student registerStudent(AddStudentDto student) {
        Student studentEntity = new Student();
        studentEntity.setStudentId(student.getStudentId());
        studentEntity.setStudentName(student.getStudentName());

        return repository.save(studentEntity);
    }

    @Override
    public Student enrollSubject(Long studentId, Long subjectId) {
        Student student = getStudent(studentId);
        Set<Subject> subjects= student.getSubjects();
        subjects.add(subjectService.getSubject(subjectId));
        student.setSubjects(subjects);
        return repository.save(student);
    }

    @Override
    public Student enrollExam(Long studentId, Long examId) {
        Student student = getStudent(studentId);
        Set<Exam> exams = student.getExams();
        exams.add(examService.getExam(examId));
        student.setExams(exams);
        return repository.save(student);
    }

    private Student getStudent(Long studentId){
        Optional<Student> student = repository.findById(studentId);
        return student.orElseThrow();
    }


}
