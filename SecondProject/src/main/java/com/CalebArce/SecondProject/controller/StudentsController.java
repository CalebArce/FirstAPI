package com.CalebArce.SecondProject.controller;

import com.CalebArce.SecondProject.entity.Students;
import com.CalebArce.SecondProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentsController {

    /*Se utiliza para la inyección de dependencias*/
    @Autowired
    StudentService studentService;

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado*/
    @GetMapping({"/displayAllStudents"})
    public List<Students> displayAllStudents() {
        if(studentService.showAllStudents().isEmpty()){
            throw new RuntimeException("No hay registros de estudiantes");//Excepción manejada dentro del package error
        }
        return studentService.showAllStudents();
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findStudentByName/{name}"})
    public Optional<Students> findStudentByName(@PathVariable String name) {
        if(studentService.findByStudentName(name).isEmpty()){
            throw new RuntimeException("El nombre ingresado no se encuentra registrado");//Excepción manejada dentro del package error
        }
        return studentService.findByStudentName(name);
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findStudentByLastName/{lastName}"})
    public Optional<Students> findStudentByLastName(@PathVariable String lastName) {
        if(studentService.findByStudentLastName(lastName).isEmpty()){
            throw new RuntimeException("El apellido ingresado no se encuentra registrado");//Excepción manejada dentro del package error
        }
        return studentService.findByStudentLastName(lastName);
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findStudentBySecondLastName/{secondLastName}"})
    public Optional<Students> findStudentBySecondLastName(@PathVariable String secondLastName) {
        if(studentService.findByStudentSecondLastName(secondLastName).isEmpty()){
            throw new RuntimeException("El segundo apellido ingresado no se encuentra registrado");//Excepción manejada dentro del package error
        }
        return studentService.findByStudentSecondLastName(secondLastName);
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findStudentByGrade/{grade}"})
    public Optional<Students> findStudentByGrade(@PathVariable String grade) {
        if(studentService.findByStudentGrade(grade).isEmpty()){
            throw new RuntimeException("El grado del estudiante ingresado no se encuentra registrado");//Excepción manejada dentro del package error
        }
        return studentService.findByStudentGrade(grade);
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findByStudentAge/{age}"})
    public Optional<Students> findByStudentAge(@PathVariable int age) {
        if(studentService.findByStudentAge(age).isEmpty()){
            throw new RuntimeException("La edad ingresada del estudiante no ha sido registrada");//Excepción manejada dentro del package error
        }
        return studentService.findByStudentAge(age);
    }

    /*El método Post mapping se utiliza para ingreso de datos que se le hayan ingresado en el package de entity en formato json*/
    @PostMapping({"/addStudents"})
    public Students addStudents(@RequestBody Students students) {
        if(students.getStudentName() == null || students.getStudentName().isEmpty()){
            throw new RuntimeException("Debe ingresar un nombre");//Excepción manejada dentro del package error
        }
        if(students.getStudentLastName() == null || students.getStudentLastName().isEmpty()){
            throw new RuntimeException("Debe ingresar un apellido");//Excepción manejada dentro del package error
        }
        if(students.getStudentSecondLastName() == null || students.getStudentSecondLastName().isEmpty()){
            throw new RuntimeException("Debe ingresar un segundo apellido");//Excepción manejada dentro del package error
        }
        if(students.getStudentAge() == null || students.getStudentAge().isEmpty()){
            throw new RuntimeException("Debe ingresar una edad");//Excepción manejada dentro del package error
        }
        if(students.getStudentEmail() == null || students.getStudentEmail().isEmpty()){
            throw new RuntimeException("Debe ingresar un email");//Excepción manejada dentro del package error
        }
        if(students.getStudentGrade() == null || students.getStudentGrade().isEmpty()){
            throw new RuntimeException("Debe ingresar un nivel de grado");//Excepción manejada dentro del package error
        }
        if(students.getStudentAddress() == null || students.getStudentAddress().isEmpty()){
            throw new RuntimeException("Debe ingresar una dirección");//Excepción manejada dentro del package error
        }
        if(students.getStudentTelephoneNumber() == null || students.getStudentTelephoneNumber().isEmpty()){
            throw new RuntimeException("Debe ingresar un número telefónico");//Excepción manejada dentro del package error
        }
        if(students.getStudentTeacherInCharge() == null || students.getStudentTeacherInCharge().isEmpty()){
            throw new RuntimeException("Debe ingresar un profesor encargado");//Excepción manejada dentro del package error
        }
        return studentService.addStudent(students);
    }

    /*el método put mapping se utiliza para mapear solicitudes de tipo HTTP a diferencia del Post se utiliza para una actualización de datos ingresando el valor del id generado por la BD*/
    @PutMapping({"/updateStudents/{id}"}) // Se crea una ruta dentro del método Put Mapping donde le especifica el nombre de la url que tendrá y el parámetro de tipo id que se encuentra dentro de la BD
    //Se utiliza una función de tipo Students para poder utilizar el servicio ingresado para actualizar los datos con un id por defecto
    public Students updateStudents(@PathVariable Long id,@RequestBody Students students) {
        if(students.getStudentName().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un nombre");//Excepción manejada dentro del package error
        }
        if(students.getStudentLastName().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un apellido");//Excepción manejada dentro del package error
        }
        if(students.getStudentSecondLastName().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un segundo apellido");//Excepción manejada dentro del package error
        }
        if(students.getStudentAge().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar una edad");//Excepción manejada dentro del package error
        }
        if(students.getStudentEmail().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un email");//Excepción manejada dentro del package error
        }
        if(students.getStudentGrade().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un nivel de grado");//Excepción manejada dentro del package error
        }
        if(students.getStudentAddress().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar una dirección");//Excepción manejada dentro del package error
        }
        if(students.getStudentTelephoneNumber().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un número telefónico");//Excepción manejada dentro del package error
        }
        if(students.getStudentTeacherInCharge().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un profesor encargado");//Excepción manejada dentro del package error
        }
        return studentService.updateStudent(id, students);
    }

    /*el método delete mapping se utiliza para eliminar registros ingresados en una base de datos dependiendo del valor que se le envie dentro de la ruta*/
    @DeleteMapping({"/deleteStudents/{id}"}) //En la ruta se pasa el valor de id el cual será utilizado para eliminar el registro ingresado el base de datos generado desde el package entity
    public String deleteStudents(@PathVariable Long id){ //Se utiliza un PathVariable para tomar de referencia el id para eliminar el registro ingresado
        studentService.deleteStudent(id); //busca dentro del studentService el parámetro dentro de la función deleteStudent el parámetro id para eliminar dicho regsitro
        return "Estudiante eliminado con éxito"; //Mostrará el mensaje de que se elimino correctamente el registro indicado por el id
    }
}
