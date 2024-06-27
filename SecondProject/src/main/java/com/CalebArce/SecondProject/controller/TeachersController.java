package com.CalebArce.SecondProject.controller;

import com.CalebArce.SecondProject.entity.Teachers;
import com.CalebArce.SecondProject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeachersController {

    /*Se utiliza para la inyección de dependencias*/
    @Autowired
    TeacherService teacherService;

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado*/
    @GetMapping({"/findAllTeachers"})
    public List<Teachers> findAllTeachers(){
        if(teacherService.showAllTeachers().isEmpty()){
            throw new RuntimeException("No hay registro de profesores");//Excepción manejada dentro del package error
        }
        return teacherService.showAllTeachers();
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findTeacherByName/{name}"})
    public Optional<Teachers> findTeacherByName(@PathVariable String name){
        if(teacherService.findTeacherByName(name).isEmpty()){
            throw new RuntimeException("El nombre del profesor ingresado no se encuentra registrado");//Excepción manejada dentro del package error
        }
        return teacherService.findTeacherByName(name);
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findTeacherByLastName/{lastName}"})
    public Optional<Teachers> findTeacherByLastName(@PathVariable String lastName){
        if(teacherService.findTeacherByLastName(lastName).isEmpty()){
            throw new RuntimeException("El apellido del profesor ingresado no se encuentra registrado");//Excepción manejada dentro del package error
        }
        return teacherService.findTeacherByLastName(lastName);
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findTeacherBySecondLastName/{secondLastName}"})
    public Optional<Teachers> findTeacherBySecondLastName(@PathVariable String secondLastName){
        if(teacherService.findTeacherBySecondLastName(secondLastName).isEmpty()){
            throw new RuntimeException("El segundo apellido del profesor ingresado no se encuentra registrado");//Excepción manejada dentro del package error
        }
        return teacherService.findTeacherBySecondLastName(secondLastName);
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping("/findTeacherByJobLicense/{jobLicense}")
    public Optional<Teachers> findTeacherByJobLicense(@PathVariable String jobLicense){
        if(teacherService.findTeacherByJobLicense(jobLicense).isEmpty()){
            throw new RuntimeException("El número de gafete del profesor ingresado no se encuentra registrado");//Excepción manejada dentro del package error
        }
        return teacherService.findTeacherByJobLicense(jobLicense);
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findTeacherBySignature/{signature}"})
    public Optional<Teachers> findTeacherBySignature(@PathVariable String signature){
        if(teacherService.findTeacherBySignature(signature).isEmpty()){
            throw new RuntimeException("La asignatura ingresada para el profesor no se encuentra registrada");//Excepción manejada dentro del package error
        }
        return teacherService.findTeacherBySignature(signature);
    }

    /*El método Post mapping se utiliza para ingreso de datos que se le hayan ingresado en el package de entity en formato json*/
    @PostMapping({"/addTeachers"})
    public Teachers addTeachers(@RequestBody Teachers teachers){
        if(teachers.getTeacherName() == null || teachers.getTeacherName().isEmpty()){
            throw new RuntimeException("Debe ingresar un nombre");//Excepción manejada dentro del package error
        }
        if(teachers.getTeacherLastName() == null || teachers.getTeacherLastName().isEmpty()){
            throw new RuntimeException("Debe ingresar un apellido");//Excepción manejada dentro del package error
        }
        if(teachers.getTeacherSecondLastName() == null || teachers.getTeacherSecondLastName().isEmpty()){
            throw new RuntimeException("Debe ingresar segundo un apellido");//Excepción manejada dentro del package error
        }
        if(teachers.getTeacherEmail() == null || teachers.getTeacherEmail().isEmpty()){
            throw new RuntimeException("Debe ingresar un email");//Excepción manejada dentro del package error
        }
        if(teachers.getTeacherJobLicense() == null || teachers.getTeacherJobLicense().isEmpty()){
            throw new RuntimeException("Debe ingresar un número de gafete");//Excepción manejada dentro del package error
        }
        if(teachers.getTeacherTelephoneNumber() == null || teachers.getTeacherTelephoneNumber().isEmpty()){
            throw new RuntimeException("Debe ingresar un número de teléfono");//Excepción manejada dentro del package error
        }
        if(teachers.getTeacherSignature() == null || teachers.getTeacherSignature().isEmpty()){
            throw new RuntimeException("Debe ingresar la asignatura del profesor");//Excepción manejada dentro del package error
        }
        return teacherService.addTeacher(teachers);
    }

    /*el método put mapping se utiliza para mapear solicitudes de tipo HTTP a diferencia del Post se utiliza para una actualización de datos ingresando el valor del id generado por la BD*/
    @PutMapping({"/updateTeachers/{id}"}) // Se crea una ruta dentro del método Put Mapping donde le especifica el nombre de la url que tendrá y el parámetro de tipo id que se encuentra dentro de la BD
    //Se utiliza una función de tipo Teachers para poder utilizar el servicio ingresado para actualizar los datos con un id por defecto
    public Teachers updateTeachers(@PathVariable Long id,@RequestBody Teachers teachers){
        if(teachers.getTeacherName().isEmpty()){
            throw new RuntimeException("Para actualizar datos debe ingresar un nombre");//Excepción manejada dentro del package error
        }
        if(teachers.getTeacherLastName().isEmpty()){
            throw new RuntimeException("Para actualizar datos debe ingresar un apellido");//Excepción manejada dentro del package error
        }
        if(teachers.getTeacherSecondLastName().isEmpty()){
            throw new RuntimeException("Para actualizar datos debe ingresar segundo un apellido");//Excepción manejada dentro del package error
        }
        if(teachers.getTeacherEmail().isEmpty()){
            throw new RuntimeException("Para actualizar datos debe ingresar un email");//Excepción manejada dentro del package error
        }
        if(teachers.getTeacherJobLicense().isEmpty()){
            throw new RuntimeException("Para actualizar datos debe ingresar un número de gafete");//Excepción manejada dentro del package error
        }
        if(teachers.getTeacherTelephoneNumber().isEmpty()){
            throw new RuntimeException("Para actualizar datos debe ingresar un número de teléfono");//Excepción manejada dentro del package error
        }
        if(teachers.getTeacherSignature().isEmpty()){
            throw new RuntimeException("Para actualizar datos debe ingresar la asignatura del profesor");//Excepción manejada dentro del package error
        }
        return teacherService.updateTeacher(id,teachers);
    }

    /*el método delete mapping se utiliza para eliminar registros ingresados en una base de datos dependiendo del valor que se le envie dentro de la ruta*/
    @DeleteMapping({"/deleteTeachers/{id}"}) //En la ruta se pasa el valor de id el cual será utilizado para eliminar el registro ingresado el base de datos generado desde el package entity
    public String deleteTeachers(@PathVariable Long id){ //Se utiliza un PathVariable para tomar de referencia el id para eliminar el registro ingresado
        teacherService.deleteTeacher(id); //Busca dentro del teacherService el parámetro dentro de la función deleteTeacher el parámetro id para eliminar dicho regsitro
        return "Educador eliminador con éxito"; //Mostrará el mensaje de que se elimino correctamente el registro indicado por el id
    }
}
