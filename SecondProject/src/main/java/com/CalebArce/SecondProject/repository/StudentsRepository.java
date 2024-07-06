package com.CalebArce.SecondProject.repository;

import com.CalebArce.SecondProject.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {

    @Query("SELECT st FROM Students st WHERE st.studentName = :studentName")
    Optional<Students> findByStudentName(String studentName);

    @Query("SELECT st FROM Students st WHERE st.studentLastName = :studentLastName")
    Optional<Students> findByStudentLastName(String studentLastName);

    @Query("SELECT st FROM Students st WHERE st.studentSecondLastName = :studentSecondLastName")
    Optional<Students> findByStudentSecondLastName(String studentSecondLastName);

    @Query("SELECT st FROM Students st WHERE st.studentGrade = :studentGrade")
    Optional<Students> findByStudentGrade(String studentGrade);

    @Query("SELECT st FROM Students st WHERE st.studentAge = :studentAge")
    Optional<Students> findByStudentAge(int studentAge);

}
