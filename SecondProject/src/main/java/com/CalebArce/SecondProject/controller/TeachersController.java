package com.CalebArce.SecondProject.controller;

import com.CalebArce.SecondProject.entity.Teachers;
import com.CalebArce.SecondProject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeachersController {

    @Autowired
    TeacherService teacherService;

    @GetMapping({"/findAllTeachers"})
    public List<Teachers> findAllTeachers(){
        if(teacherService.showAllTeachers().isEmpty()){
            throw new RuntimeException("No hay registro de profesores");
        }
        return teacherService.showAllTeachers();
    }

    @GetMapping({"/findTeacherByName/{name}"})
    public Optional<Teachers> findTeacherByName(@PathVariable String name){
        if(teacherService.findTeacherByName(name).isEmpty()){
            throw new RuntimeException("El nombre del profesor ingresado no se encuentra registrado");
        }
        return teacherService.findTeacherByName(name);
    }

    @GetMapping({"/findTeacherByLastName/{lastName}"})
    public Optional<Teachers> findTeacherByLastName(@PathVariable String lastName){
        if(teacherService.findTeacherByLastName(lastName).isEmpty()){
            throw new RuntimeException("El apellido del profesor ingresado no se encuentra registrado");
        }
        return teacherService.findTeacherByLastName(lastName);
    }

    @GetMapping({"/findTeacherBySecondLastName/{secondLastName}"})
    public Optional<Teachers> findTeacherBySecondLastName(@PathVariable String secondLastName){
        if(teacherService.findTeacherBySecondLastName(secondLastName).isEmpty()){
            throw new RuntimeException("El segundo apellido del profesor ingresado no se encuentra registrado");
        }
        return teacherService.findTeacherBySecondLastName(secondLastName);
    }

    @GetMapping("/findTeacherByJobLicense/{jobLicense}")
    public Optional<Teachers> findTeacherByJobLicense(@PathVariable String jobLicense){
        if(teacherService.findTeacherByJobLicense(jobLicense).isEmpty()){
            throw new RuntimeException("El número de gafete del profesor ingresado no se encuentra registrado");
        }
        return teacherService.findTeacherByJobLicense(jobLicense);
    }

    @GetMapping({"/findTeacherBySignature/{signature}"})
    public Optional<Teachers> findTeacherBySignature(@PathVariable String signature){
        if(teacherService.findTeacherBySignature(signature).isEmpty()){
            throw new RuntimeException("La asignatura ingresada para el profesor no se encuentra registrada");
        }
        return teacherService.findTeacherBySignature(signature);
    }

    @PostMapping({"/addTeachers"})
    public Teachers addTeachers(@RequestBody Teachers teachers){
        if(teachers.getTeacherName() == null || teachers.getTeacherName().isEmpty()){
            throw new RuntimeException("Debe ingresar un nombre");
        }
        if(teachers.getTeacherLastName() == null || teachers.getTeacherLastName().isEmpty()){
            throw new RuntimeException("Debe ingresar un apellido");
        }
        if(teachers.getTeacherSecondLastName() == null || teachers.getTeacherSecondLastName().isEmpty()){
            throw new RuntimeException("Debe ingresar segundo un apellido");
        }
        if(teachers.getTeacherEmail() == null || teachers.getTeacherEmail().isEmpty()){
            throw new RuntimeException("Debe ingresar un email");
        }
        if(teachers.getTeacherJobLicense() == null || teachers.getTeacherJobLicense().isEmpty()){
            throw new RuntimeException("Debe ingresar un número de gafete");
        }
        if(teachers.getTeacherTelephoneNumber() == null || teachers.getTeacherTelephoneNumber().isEmpty()){
            throw new RuntimeException("Debe ingresar un número de teléfono");
        }
        if(teachers.getTeacherSignature() == null || teachers.getTeacherSignature().isEmpty()){
            throw new RuntimeException("Debe ingresar la asignatura del profesor");
        }
        return teacherService.addTeacher(teachers);
    }

    @PutMapping({"/updateTeachers/{id}"})
    public Teachers updateTeachers(@PathVariable Long id,@RequestBody Teachers teachers){
        if(teachers.getTeacherName().isEmpty()){
            throw new RuntimeException("Para actualizar datos debe ingresar un nombre");
        }
        if(teachers.getTeacherLastName().isEmpty()){
            throw new RuntimeException("Para actualizar datos debe ingresar un apellido");
        }
        if(teachers.getTeacherSecondLastName().isEmpty()){
            throw new RuntimeException("Para actualizar datos debe ingresar segundo un apellido");
        }
        if(teachers.getTeacherEmail().isEmpty()){
            throw new RuntimeException("Para actualizar datos debe ingresar un email");
        }
        if(teachers.getTeacherJobLicense().isEmpty()){
            throw new RuntimeException("Para actualizar datos debe ingresar un número de gafete");
        }
        if(teachers.getTeacherTelephoneNumber().isEmpty()){
            throw new RuntimeException("Para actualizar datos debe ingresar un número de teléfono");
        }
        if(teachers.getTeacherSignature().isEmpty()){
            throw new RuntimeException("Para actualizar datos debe ingresar la asignatura del profesor");
        }
        return teacherService.updateTeacher(id,teachers);
    }

    @DeleteMapping({"/deleteTeachers/{id}"})
    public String deleteTeachers(@PathVariable Long id){
        teacherService.deleteTeacher(id);
        return "Educador eliminador con éxito";
    }
}
