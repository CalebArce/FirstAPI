package com.CalebArce.SecondProject.serviceImplementation;

import com.CalebArce.SecondProject.entity.Students;
import com.CalebArce.SecondProject.repository.StudentsRepository;
import com.CalebArce.SecondProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentsRepository studentsRepository;

    @Override
    public List<Students> showAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public Students addStudent(Students students) {
        return studentsRepository.save(students);
    }

    @Override
    public Students updateStudent(Long id, Students students) {
        Students studentsDB = studentsRepository.findById(id).get();
        return studentsRepository.save(studentsDB);
    }

    @Override
    public String deleteStudent(Long id) {
        studentsRepository.deleteById(id);
        return "Estudiante eliminado";
    }

    @Override
    public Optional<Students> findByStudentName(String studentName) {
        return studentsRepository.findByStudentName(studentName);
    }

    @Override
    public Optional<Students> findByStudentLastName(String studentLastName) {
        return studentsRepository.findByStudentLastName(studentLastName);
    }

    @Override
    public Optional<Students> findByStudentSecondLastName(String studentSecondLastName) {
        return studentsRepository.findByStudentSecondLastName(studentSecondLastName);
    }

    @Override
    public Optional<Students> findByStudentGrade(String studentGrade) {
        return studentsRepository.findByStudentGrade(studentGrade);
    }

    @Override
    public Optional<Students> findByStudentAge(int studentAge) {
        return studentsRepository.findByStudentAge(studentAge);
    }
}
