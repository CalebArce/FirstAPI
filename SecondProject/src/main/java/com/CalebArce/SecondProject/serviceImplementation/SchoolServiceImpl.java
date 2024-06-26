package com.CalebArce.SecondProject.serviceImplementation;

import com.CalebArce.SecondProject.entity.School;
import com.CalebArce.SecondProject.repository.SchoolRepository;
import com.CalebArce.SecondProject.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public List<School> showAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School updateSchool(Long id, School school) {
        School schoolDB = schoolRepository.findById(id).get();
        return schoolRepository.save(schoolDB);
    }

    @Override
    public String deleteSchool(Long id) {
        School schoolDB = schoolRepository.findById(id).get();
        return "Centro educativo eliminado";
    }

    @Override
    public Optional<School> findSchoolByName(String schoolName) {
        return schoolRepository.findSchoolByName(schoolName);
    }

    @Override
    public Optional<School> findSchoolByProvince(String schoolProvince) {
        return schoolRepository.findSchoolByProvince(schoolProvince);
    }

    @Override
    public Optional<School> findSchoolByCity(String schoolCity) {
        return schoolRepository.findSchoolByCity(schoolCity);
    }

    @Override
    public Optional<School> findSchoolByDistrict(String schoolDistrict) {
        return schoolRepository.findSchoolByDistrict(schoolDistrict);
    }

    @Override
    public Optional<School> findSchoolByCode(String schoolCode) {
        return schoolRepository.findSchoolByCode(schoolCode);
    }
}
