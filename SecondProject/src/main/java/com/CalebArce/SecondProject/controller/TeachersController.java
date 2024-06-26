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
        /*AGREGAR CONDICIONES*/
        return teacherService.addTeacher(teachers);
    }

    @PutMapping({"/updateTeachers/{id}"})
    public Teachers updateTeachers(@PathVariable Long id,@RequestBody Teachers teachers){
        /*AGREGAR CONDICIONALES*/
        return teacherService.updateTeacher(id,teachers);
    }

    @DeleteMapping({"/deleteTeachers/{id}"})
    public String deleteTeachers(@PathVariable Long id){
        teacherService.deleteTeacher(id);
        return "Educador eliminador con éxito";
    }
}
