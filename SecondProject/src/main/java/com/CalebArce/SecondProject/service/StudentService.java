package com.CalebArce.SecondProject.service;

import com.CalebArce.SecondProject.entity.Students;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Students> showAllStudents();
    Students addStudent(Students students);
    Students updateStudent(Long id,Students students);
    String deleteStudent(Long id);

    /*BÚSQUEDAS PARA STUDENTS*/
    Optional<Students> findByStudentName(String studentName);
    Optional<Students> findByStudentLastName(String studentLastName);
    Optional<Students> findByStudentSecondLastName(String studentSecondLastName);
    Optional<Students> findByStudentGrade(String studentGrade);
    Optional<Students> findByStudentAge(int studentAge);
}
