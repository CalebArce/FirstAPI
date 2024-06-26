package com.CalebArce.SecondProject.controller;

import com.CalebArce.SecondProject.entity.School;
import com.CalebArce.SecondProject.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @GetMapping({"/findAllSchools"})
    public List<School> findAllSchools() {
        if(schoolService.showAllSchools().isEmpty()){
            throw new RuntimeException("No hay registro de centros educativos");
        }
        return schoolService.showAllSchools();
    }

    @GetMapping({"/findSchoolByName/{name}"})
    public Optional<School> findSchoolByName(@PathVariable String name) {
        if(schoolService.findSchoolByName(name).isEmpty()){
            throw new RuntimeException("El centro educativo ingresado no se encuentra registrado");
        }
        return schoolService.findSchoolByName(name);
    }

    @GetMapping({"/findSchoolByProvince/{province}"})
    public Optional<School> findSchoolByProvince(@PathVariable String province) {
        if(schoolService.findSchoolByProvince(province).isEmpty()){
            throw new RuntimeException("La provincia ingresada por centro educativo no se encuentra registrada");
        }
        return schoolService.findSchoolByProvince(province);
    }

    @GetMapping({"/findSchoolByCity/{city}"})
    public Optional<School> findSchoolByCity(@PathVariable String city) {
        if(schoolService.findSchoolByCity(city).isEmpty()){
            throw new RuntimeException("El cantón ingresado por centro educativo no se encuentra registrado");
        }
        return schoolService.findSchoolByCity(city);
    }

    @GetMapping({"/findSchoolByDistrict/{district}"})
    public Optional<School> findSchoolByDistrict(@PathVariable String district) {
        if(schoolService.findSchoolByDistrict(district).isEmpty()){
            throw new RuntimeException("El distrito ingresado por centro educativo no se encuentra registrado");
        }
        return schoolService.findSchoolByDistrict(district);
    }

    @GetMapping({"/findSchoolByCode/{code}"})
    public Optional<School> findSchoolByCode(@PathVariable String code) {
        if(schoolService.findSchoolByCode(code).isEmpty()){
            throw new RuntimeException("El código ingresado por centro educativo no se encuentra registrado");
        }
        return schoolService.findSchoolByCode(code);
    }

    @PostMapping({"/addSchool"})
    public School addSchool(@RequestBody School school) {
        if(school.getSchoolName() == null || school.getSchoolName().isEmpty()) {
            throw new RuntimeException("Debe ingresar un nombre al centro educativo");
        }
        if(school.getSchoolProvince() == null || school.getSchoolProvince().isEmpty()) {
            throw new RuntimeException("Debe ingresar una provincia al centro educativo");
        }
        if(school.getSchoolCity() == null || school.getSchoolCity().isEmpty()) {
            throw new RuntimeException("Debe ingresar un cantón al centro educativo");
        }
        if(school.getSchoolDistrict() == null || school.getSchoolDistrict().isEmpty()) {
            throw new RuntimeException("Debe ingresar un distrito al centro educativo");
        }
        if(school.getSchoolEmail() == null || school.getSchoolEmail().isEmpty()) {
            throw new RuntimeException("Debe ingresar un email al centro educativo");
        }
        if(school.getSchoolCode() == null || school.getSchoolCode().isEmpty()) {
            throw new RuntimeException("Debe ingresar un código al centro educativo");
        }
        if(school.getSchoolTelephoneNumber() == null || school.getSchoolTelephoneNumber().isEmpty()) {
            throw new RuntimeException("Debe ingresar un número telefónico al centro educativo");
        }
        if(school.getSchoolQuantityTeachers() <= 0){
            throw new RuntimeException("La cantidad de profesores no puede ser nula");
        }
        if(school.getSchoolQuantityStudents() <= 0){
            throw new RuntimeException("La cantidad de estudiantes no puede ser nula");
        }
        return schoolService.addSchool(school);
    }

    @PutMapping({"/updateSchool/{id}"})
    public School updateSchool(@PathVariable Long id, @RequestBody School school) {
        if(school.getSchoolName() == null || school.getSchoolName().isEmpty()) {
            throw new RuntimeException("Para actualizar debe ingresar un nombre al centro educativo");
        }
        if(school.getSchoolEmail().isEmpty()) {
            throw new RuntimeException("Para actualizar debe ingresar un email al centro educativo");
        }
        if(school.getSchoolCode().isEmpty()) {
            throw new RuntimeException("Para actualizar debe ingresar un código al centro educativo");
        }
        if(school.getSchoolTelephoneNumber().isEmpty()) {
            throw new RuntimeException("Para actualizar debe ingresar un número telefónico al centro educativo");
        }
        if(school.getSchoolQuantityTeachers() <= 0){
            throw new RuntimeException("Para actualizar la cantidad de profesores no puede ser nula");
        }
        if(school.getSchoolQuantityStudents() <= 0){
            throw new RuntimeException("Para actualizar la cantidad de estudiantes no puede ser nula");
        }
        return schoolService.updateSchool(id, school);
    }

    @DeleteMapping({"/deleteSchool/{id}"})
    public String deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
        return "Centro educativo eliminado con éxito";
    }
}


/*
* SE ESPERA QUE EL USUARIO HAGA UN REGISTRO DE UN CENTRO EDUCATIVO CON LAS VARIABLES INDICADAS DE TIPO STRING PARA UN
* MANEJO MÁS APTO PARA EL TRATO DE LAS EXCEPCIONES Y AUTOMÁTICAMENTE SI TODOS LOS DATOS SON VÁLIDOS INGRESARLOS EN LA
* BASE DE DATOS DE NOMBRE "tlb_students" TAMBIÉN EL USUARIO PUEDE HACER BÚSQUEDAS ESPECÍFICAS DENTRO DEL MISMO
* CONTROLLER PERO CADA UNA TIENE UNA CONDICIÓN DE SI NO EXISTE DICHO VALOR EN LA BASE DE DATOS Y MOSTRAR UN MENSAJE DE
* TIPO RuntimeException QUE SON EXCEPCIONES EN TIEMPO DE EJECUCIÓN Y SON MÁS FÁCILES PARA EL MANEJO DE LAS MISMAS. DONDE
* FINALMENTE EL ENCARGADO DE MANEJAR LA INFORMACIÓN TIENE UNA OPCIÓN PARA ELIMINAR REGISTROS POR MEDIO DEL ID GENERADO
* POR LA BASE DATOS.
*
* it wait the user who has the control of the information makes a register of the schools with the specific data
* of String type. But, if the user inserts something wrong, the program are able to display a runtime exception with the
* specific problem occurs in runtime  If the data what was enter were correct, these data will save in the database
 */