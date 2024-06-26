package com.CalebArce.SecondProject.serviceImplementation;

import com.CalebArce.SecondProject.entity.Teachers;
import com.CalebArce.SecondProject.repository.TeachersRepository;
import com.CalebArce.SecondProject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeachersRepository teachersRepository;

    @Override
    public List<Teachers> showAllTeachers() {
        return teachersRepository.findAll();
    }

    @Override
    public Teachers addTeacher(Teachers teachers) {
        return teachersRepository.save(teachers);
    }

    @Override
    public Teachers updateTeacher(Long id, Teachers teachers) {
        Teachers teachersDB = teachersRepository.findById(id).get();
        return teachersRepository.save(teachersDB);
    }

    @Override
    public String deleteTeacher(Long id) {
        teachersRepository.deleteById(id);
        return "Profesor eliminado";
    }

    @Override
    public Optional<Teachers> findTeacherByName(String teacherName) {
        return teachersRepository.findTeacherByName(teacherName);
    }

    @Override
    public Optional<Teachers> findTeacherByLastName(String lastName) {
        return teachersRepository.findTeacherByLastName(lastName);
    }

    @Override
    public Optional<Teachers> findTeacherBySecondLastName(String teacherSecondLastName) {
        return teachersRepository.findTeacherBySecondLastName(teacherSecondLastName);
    }

    @Override
    public Optional<Teachers> findTeacherByJobLicense(String teacherJobLicense) {
        return teachersRepository.findTeacherByJobLicense(teacherJobLicense);
    }

    @Override
    public Optional<Teachers> findTeacherBySignature(String teacherSignature) {
        return teachersRepository.findTeacherBySignature(teacherSignature);
    }
}
