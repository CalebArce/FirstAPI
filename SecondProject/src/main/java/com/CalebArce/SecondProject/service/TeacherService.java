package com.CalebArce.SecondProject.service;

import com.CalebArce.SecondProject.entity.Teachers;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<Teachers> showAllTeachers();
    Teachers addTeacher(Teachers teachers);
    Teachers updateTeacher(Long id,Teachers teachers);
    String deleteTeacher(Long id);

    /*BÚSQUEDA PARA TEACHERS*/
    Optional<Teachers> findTeacherByName(String teacherName);
    Optional<Teachers> findTeacherByLastName(String lastName);
    Optional<Teachers> findTeacherBySecondLastName(String teacherSecondLastName);
    Optional<Teachers> findTeacherByJobLicense(String teacherJobLicense);
    Optional<Teachers> findTeacherBySignature(String teacherSignature);
}
