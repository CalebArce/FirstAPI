package com.CalebArce.SecondProject.service;

import com.CalebArce.SecondProject.entity.School;

import java.util.List;
import java.util.Optional;

public interface SchoolService {

    List<School> showAllSchools();
    School addSchool(School school);
    School updateSchool(Long id,School school);
    String deleteSchool(Long id);

    /*BÚSQUEDAS PARA SCHOOL (CENTRO EDUCATIVO)*/
    Optional<School> findSchoolByName(String schoolName);
    Optional<School> findSchoolByProvince(String schoolProvince);
    Optional<School> findSchoolByCity(String schoolCity);
    Optional<School> findSchoolByDistrict(String schoolDistrict);
    Optional<School> findSchoolByCode(String schoolCode);
}
