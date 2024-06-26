package com.CalebArce.SecondProject.repository;

import com.CalebArce.SecondProject.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeachersRepository extends JpaRepository<Teachers,Long> {

    @Query("SELECT t FROM Teachers t WHERE t.teacherName = :teacherName")
    Optional<Teachers> findTeacherByName(String teacherName);

    @Query("SELECT t FROM Teachers t WHERE t.teacherLastName = :lastName")
    Optional<Teachers> findTeacherByLastName(String lastName);

    @Query("SELECT t FROM Teachers t WHERE t.teacherSecondLastName = :teacherSecondLastName")
    Optional<Teachers> findTeacherBySecondLastName(String teacherSecondLastName);

    @Query("SELECT t FROM Teachers t WHERE t.teacherJobLicense = :teacherJobLicense")
    Optional<Teachers> findTeacherByJobLicense(String teacherJobLicense);

    @Query("SELECT t FROM Teachers t WHERE t.teacherSignature = :teacherSignature")
    Optional<Teachers> findTeacherBySignature(String teacherSignature);

}
