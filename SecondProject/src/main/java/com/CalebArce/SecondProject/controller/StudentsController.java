package com.CalebArce.SecondProject.controller;

import com.CalebArce.SecondProject.entity.Students;
import com.CalebArce.SecondProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentsController {

    @Autowired
    StudentService studentService;

    @GetMapping({"/displayAllStudents"})
    public List<Students> displayAllStudents() {
        if(studentService.showAllStudents().isEmpty()){
            throw new RuntimeException("No hay registros de estudiantes");
        }
        return studentService.showAllStudents();
    }

    @GetMapping({"/findStudentByName/{name}"})
    public Optional<Students> findStudentByName(@PathVariable String name) {
        if(studentService.findByStudentName(name).isEmpty()){
            throw new RuntimeException("El nombre ingresado no se encuentra registrado");
        }
        return studentService.findByStudentName(name);
    }

    @GetMapping({"/findStudentByLastName/{lastName}"})
    public Optional<Students> findStudentByLastName(@PathVariable String lastName) {
        if(studentService.findByStudentLastName(lastName).isEmpty()){
            throw new RuntimeException("El apellido ingresado no se encuentra registrado");
        }
        return studentService.findByStudentLastName(lastName);
    }

    @GetMapping({"/findStudentBySecondLastName/{secondLastName}"})
    public Optional<Students> findStudentBySecondLastName(@PathVariable String secondLastName) {
        if(studentService.findByStudentSecondLastName(secondLastName).isEmpty()){
            throw new RuntimeException("El segundo apellido ingresado no se encuentra registrado");
        }
        return studentService.findByStudentSecondLastName(secondLastName);
    }

    @GetMapping({"/findStudentByGrade/{grade}"})
    public Optional<Students> findStudentByGrade(@PathVariable String grade) {
        if(studentService.findByStudentGrade(grade).isEmpty()){
            throw new RuntimeException("El grado del estudiante ingresado no se encuentra registrado");
        }
        return studentService.findByStudentGrade(grade);
    }

    @GetMapping({"/findByStudentAge/{age}"})
    public Optional<Students> findByStudentAge(@PathVariable int age) {
        if(studentService.findByStudentAge(age).isEmpty()){
            throw new RuntimeException("La edad ingresada del estudiante no ha sido registrada");
        }
        return studentService.findByStudentAge(age);
    }

    @PostMapping({"/addStudents"})
    public Students addStudents(@RequestBody Students students) {
        if(students.getStudentName() == null || students.getStudentName().isEmpty()){
            throw new RuntimeException("Debe ingresar un nombre");
        }
        if(students.getStudentLastName() == null || students.getStudentLastName().isEmpty()){
            throw new RuntimeException("Debe ingresar un apellido");
        }
        if(students.getStudentSecondLastName() == null || students.getStudentSecondLastName().isEmpty()){
            throw new RuntimeException("Debe ingresar un segundo apellido");
        }
        if(students.getStudentAge() == null || students.getStudentAge().isEmpty()){
            throw new RuntimeException("Debe ingresar una edad");
        }
        if(students.getStudentEmail() == null || students.getStudentEmail().isEmpty()){
            throw new RuntimeException("Debe ingresar un email");
        }
        if(students.getStudentGrade() == null || students.getStudentGrade().isEmpty()){
            throw new RuntimeException("Debe ingresar un nivel de grado");
        }
        if(students.getStudentAddress() == null || students.getStudentAddress().isEmpty()){
            throw new RuntimeException("Debe ingresar una dirección");
        }
        if(students.getStudentTelephoneNumber() == null || students.getStudentTelephoneNumber().isEmpty()){
            throw new RuntimeException("Debe ingresar un número telefónico");
        }
        if(students.getStudentTeacherInCharge() == null || students.getStudentTeacherInCharge().isEmpty()){
            throw new RuntimeException("Debe ingresar un profesor encargado");
        }
        return studentService.addStudent(students);
    }

    @PutMapping({"/updateStudents/{id}"})
    /*AGREGAR CONDICIONALES*/
    public Students updateStudents(@PathVariable Long id,@RequestBody Students students) {
        return studentService.updateStudent(id, students);
    }

    @DeleteMapping({"/deleteStudents/{id}"})
    public String deleteStudents(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Estudiante eliminado con éxito";
    }
}
