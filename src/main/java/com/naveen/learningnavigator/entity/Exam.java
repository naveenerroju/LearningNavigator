package com.naveen.learningnavigator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exams")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;

    // Many-to-One relationship with Subject
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    // Many-to-Many relationship with Student
    @ManyToMany(mappedBy = "exams")
    private Set<Student> students = new HashSet<>();

}