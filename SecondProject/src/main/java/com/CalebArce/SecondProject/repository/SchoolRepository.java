package com.CalebArce.SecondProject.repository;

import com.CalebArce.SecondProject.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {

    @Query("SELECT s FROM School s WHERE s.schoolName = :schoolName")
    Optional<School> findSchoolByName(String schoolName);

    @Query("SELECT s FROM School s WHERE s.schoolProvince = :schoolProvince")
    Optional<School> findSchoolByProvince(String schoolProvince);

    @Query("SELECT s FROM School s WHERE s.schoolCity = :schoolCity")
    Optional<School> findSchoolByCity(String schoolCity);

    @Query("SELECT s FROM School s WHERE s.schoolDistrict = :schoolDistrict")
    Optional<School> findSchoolByDistrict(String schoolDistrict);

    @Query("SELECT s FROM School s WHERE s.schoolCode = :schoolCode")
    Optional<School> findSchoolByCode(String schoolCode);

}
