package com.CalebArce.SecondProject.controller;

import com.CalebArce.SecondProject.entity.School;
import com.CalebArce.SecondProject.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SchoolController {

    /*Se utiliza para la inyección de dependencias*/
    @Autowired
    SchoolService schoolService;

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado*/
    @GetMapping({"/findAllSchools"})
    //Se utiliza una lista con el parámetro del package entity school para que muestre todos los registros que se han hecho
    public List<School> findAllSchools() {
        if(schoolService.showAllSchools().isEmpty()){ //Si la lista con el parámetro school no encuentra ningún registro en el showAllSchools lanzará una excepción
            throw new RuntimeException("No hay registro de centros educativos"); //Excepción utilizada en tiempo de ejecución
        }
        return schoolService.showAllSchools();//Devuelve una respuesta a la solicitud por medio del GET MAPPING
    }
    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creador e incluso ingresando una variable de referencia*/
    @GetMapping({"/findSchoolByName/{name}"})
    //Se utiliza un optional con el parámetro del package entity school para verificar buscar que exista algún registro
    public Optional<School> findSchoolByName(@PathVariable String name) { //Se utiliza un PathVariable para tomar de referencia la variable a buscar
        if(schoolService.findSchoolByName(name).isEmpty()){ // Verifica que no esté vacío el nombre del centro educativo para mostrar los registros relacionados con la misma
            throw new RuntimeException("El centro educativo ingresado no se encuentra registrado");//Excepción utilizada en tiempo de ejecución
        }
        return schoolService.findSchoolByName(name); //Devuelve una respuesta a la solicitud por medio del GET MAPPING
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creador e incluso ingresando una variable de referencia*/
    @GetMapping({"/findSchoolByProvince/{province}"})
    //Se utiliza un optional con el parámetro del package entity school para verificar buscar que exista algún registro
    public Optional<School> findSchoolByProvince(@PathVariable String province) { //Se utiliza un PathVariable para tomar de referencia la variable a buscar
        if(schoolService.findSchoolByProvince(province).isEmpty()){ // Verifica que no esté vacío la provincia del centro educativo para mostrar los registros relacionados con la misma
            throw new RuntimeException("La provincia ingresada por centro educativo no se encuentra registrada");//Excepción utilizada en tiempo de ejecución
        }
        return schoolService.findSchoolByProvince(province);//Devuelve una respuesta a la solicitud por medio del GET MAPPING
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creador e incluso ingresando una variable de referencia*/
    @GetMapping({"/findSchoolByCity/{city}"})
    //Se utiliza un optional con el parámetro del package entity school para verificar buscar que exista algún registro
    public Optional<School> findSchoolByCity(@PathVariable String city) { //Se utiliza un PathVariable para tomar de referencia la variable a buscar
        if(schoolService.findSchoolByCity(city).isEmpty()){ // Verifica que no esté vacío el cantón del centro educativo para mostrar los registros relacionados con la misma
            throw new RuntimeException("El cantón ingresado por centro educativo no se encuentra registrado");//Excepción utilizada en tiempo de ejecución
        }
        return schoolService.findSchoolByCity(city);//Devuelve una respuesta a la solicitud por medio del GET MAPPING
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creador e incluso ingresando una variable de referencia*/
    @GetMapping({"/findSchoolByDistrict/{district}"})
    //Se utiliza un optional con el parámetro del package entity school para verificar buscar que exista algún registro
    public Optional<School> findSchoolByDistrict(@PathVariable String district) { //Se utiliza un PathVariable para tomar de referencia la variable a buscar
        if(schoolService.findSchoolByDistrict(district).isEmpty()){ // Verifica que no esté vacío el distrito del centro educativo para mostrar los registros relacionados con la misma
            throw new RuntimeException("El distrito ingresado por centro educativo no se encuentra registrado");//Excepción utilizada en tiempo de ejecución
        }
        return schoolService.findSchoolByDistrict(district);//Devuelve una respuesta a la solicitud por medio del GET MAPPING
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creador e incluso ingresando una variable de referencia*/
    @GetMapping({"/findSchoolByCode/{code}"})
    //Se utiliza un optional con el parámetro del package entity school para verificar buscar que exista algún registro
    public Optional<School> findSchoolByCode(@PathVariable String code) { //Se utiliza un PathVariable para tomar de referencia la variable a buscar
        //Contiene una condición la cual verifica si existe algún código existente de lo contrario se lanzará una excepción
        if(schoolService.findSchoolByCode(code).isEmpty()){ //si no se encuentra vacío el código del centro educativo se lanza la excepción
            throw new RuntimeException("El código ingresado por centro educativo no se encuentra registrado");//Excepción utilizada en tiempo de ejecución
        }
        return schoolService.findSchoolByCode(code);//Devuelve una respuesta a la solicitud por medio del GET MAPPING
    }

    /*El método Post mapping se utiliza para ingreso de datos que se le hayan ingresado en el package de entity en formato json*/
    @PostMapping({"/addSchool"})
    public School addSchool(@RequestBody School school) { //se utiliza el @request body unicamente para métodos controladores con la entity School para
        //Verifica que el nombre del centro educativo no sea nulo ni esté vacío
        if(school.getSchoolName() == null || school.getSchoolName().isEmpty()) {
            throw new RuntimeException("Debe ingresar un nombre al centro educativo");//Excepción utilizada en tiempo de ejecución
        }
        //Verifica que la provincia del centro educativo no sea nula ni esté vacía
        if(school.getSchoolProvince() == null || school.getSchoolProvince().isEmpty()) {
            throw new RuntimeException("Debe ingresar una provincia al centro educativo");//Excepción utilizada en tiempo de ejecución
        }
        //Verifica que el cantón del centro educativo no sea nulo ni esté vacío
        if(school.getSchoolCity() == null || school.getSchoolCity().isEmpty()) {
            throw new RuntimeException("Debe ingresar un cantón al centro educativo");//Excepción utilizada en tiempo de ejecución
        }
        //Verifica que el distrito del centro educativo no sea nulo ni esté vacío
        if(school.getSchoolDistrict() == null || school.getSchoolDistrict().isEmpty()) {
            throw new RuntimeException("Debe ingresar un distrito al centro educativo");//Excepción utilizada en tiempo de ejecución
        }
        //Verifica que el email del centro educativo no sea nulo ni esté vacío
        if(school.getSchoolEmail() == null || school.getSchoolEmail().isEmpty()) {
            throw new RuntimeException("Debe ingresar un email al centro educativo");//Excepción utilizada en tiempo de ejecución
        }
        //Verifica que el código del centro educativo no nulo ni esté vacío
        if(school.getSchoolCode() == null || school.getSchoolCode().isEmpty()) {
            throw new RuntimeException("Debe ingresar un código al centro educativo");//Excepción utilizada en tiempo de ejecución
        }
        //Verifica que el número de teléfono centro educativo no sea nulo ni esté vacío y que no contenga guiones
        if(school.getSchoolTelephoneNumber() == null || school.getSchoolTelephoneNumber().isEmpty() ||
                !school.getSchoolTelephoneNumber().equals("-")) {
            throw new RuntimeException("Debe ingresar un número telefónico al centro educativo");//Excepción utilizada en tiempo de ejecución
        }
        //Verifica que la cantidad de profesores del centro educativo no sea menor o igual a 0
        if(school.getSchoolQuantityTeachers() <= 0){
            throw new RuntimeException("La cantidad de profesores no puede ser nula");//Excepción utilizada en tiempo de ejecución
        }
        //Verifica que la cantidad de estudiantes del centro educativo no sea menor o igual a 0
        if(school.getSchoolQuantityStudents() <= 0){
            throw new RuntimeException("La cantidad de estudiantes no puede ser nula");//Excepción utilizada en tiempo de ejecución
        }
        return schoolService.addSchool(school);//Devuelve una respuesta a la solicitud por medio del POST MAPPING
    }

    /*el método put mapping se utiliza para mapear solicitudes de tipo HTTP a diferencia del Post se utiliza para una actualización de datos ingresando el valor del id generado por la BD*/
    @PutMapping({"/updateSchool/{id}"}) // Se crea una ruta dentro del método Put Mapping donde le especifica el nombre de la url que tendrá y el id que se encuentra dentro de la BD
    //Se utiliza una función de tipo School para poder utilizar el servicio ingresado para actualizar los datos con un id por defecto
    public School updateSchool(@PathVariable Long id, @RequestBody School school) {
        if(school.getSchoolName().isEmpty()) { //Verifica que el centro educativo no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un nombre al centro educativo");//Excepción utilizada en tiempo de ejecución
        }
        if(school.getSchoolEmail().isEmpty()) { //Verifica que el email no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un email al centro educativo");//Excepción utilizada en tiempo de ejecución
        }
        if(school.getSchoolCode().isEmpty()) { //Verifica que el código no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un código al centro educativo");//Excepción utilizada en tiempo de ejecución
        }
        if(school.getSchoolTelephoneNumber().isEmpty() || !school.getSchoolTelephoneNumber().equals("-")) { //Verifica que el número telefónico no esté vacío y que no contenga guiones
            throw new RuntimeException("Para actualizar debe ingresar un número telefónico al centro educativo");//Excepción utilizada en tiempo de ejecución
        }
        if(school.getSchoolQuantityTeachers() <= 0){ //Verifica que la cantidad de profesores sea mayor a 0
            throw new RuntimeException("Para actualizar la cantidad de profesores no puede ser nula");//Excepción utilizada en tiempo de ejecución
        }
        if(school.getSchoolQuantityStudents() <= 0){ //Verifica que la cantidad de estudiantes sea mayor a 0
            throw new RuntimeException("Para actualizar la cantidad de estudiantes no puede ser nula");//Excepción utilizada en tiempo de ejecución
        }
        return schoolService.updateSchool(id, school); //Devuelve una respuesta a la solicitud por medio del PUT MAPPING
    }

    /*el método delete mapping se utiliza para eliminar registros ingresados en una base de datos dependiendo del valor que se le envie dentro de la ruta*/
    @DeleteMapping({"/deleteSchool/{id}"}) //En la ruta se pasa el valor de id el cual será utilizado para eliminar el registro ingresado el base de datos generado desde el package entity
    //Se utiliza una función de tipo String para devolver un mensaje al usuario de que eliminó un registro correctamente
    public String deleteSchool(@PathVariable Long id) {//Se utiliza un PathVariable para tomar de referencia el id para eliminar el registro ingresado
        schoolService.deleteSchool(id); //Busca dentro del schoolService el parámetro dentro de la función deleteSchool el parámetro id para eliminar dicho regsitro
        return "Centro educativo eliminado con éxito"; //Devuelve una respuesta a la solicitud por medio del DELETE MAPPING
    }
}
