package com.CalebArce.SecondProject.controller;

import com.CalebArce.SecondProject.entity.Students;
import com.CalebArce.SecondProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Se utiliza para denotar a una clase que será de tipo controlador y donde se podrán ingresar las anotaciones de solicitudes HTTP
public class StudentsController {

    /*Se utiliza para la inyección de dependencias*/
    @Autowired
    StudentService studentService;

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado*/
    @GetMapping({"/displayAllStudents"})
    public List<Students> displayAllStudents() {
        if(studentService.showAllStudents().isEmpty()){ //Verifica si hay registros dentro del método showAllStudents
            throw new RuntimeException("No hay registros de estudiantes");//Excepción utilizada en tiempo de ejecución
        }
        return studentService.showAllStudents(); //Devuelve los registros que se ingresaron
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findStudentByName/{name}"})
    public Optional<Students> findStudentByName(@PathVariable String name) { //Toma el valor dentro de los paréntesis como referencia para buscar los registros en la BD
        if(studentService.findByStudentName(name).isEmpty()){ //Verifica si el nombre ingresado dentro del método findByStudentName no se encuentra vacía
            throw new RuntimeException("El nombre ingresado no se encuentra registrado");//Excepción utilizada en tiempo de ejecución
        }
        return studentService.findByStudentName(name); //Devuelve los registros que se relacionen con el nombre del estudiante
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findStudentByLastName/{lastName}"})
    public Optional<Students> findStudentByLastName(@PathVariable String lastName){ //Toma el valor dentro de los paréntesis como referencia para buscar los registros en la BD
        if(studentService.findByStudentLastName(lastName).isEmpty()){ //Verifica si el primer apellido ingresado dentro del método findByStudentLastName no se encuentra vacía
            throw new RuntimeException("El apellido ingresado no se encuentra registrado");//Excepción utilizada en tiempo de ejecución
        }
        return studentService.findByStudentLastName(lastName); //Devuelve los registros que se relacionen con el primer apellido del estudiante
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findStudentBySecondLastName/{secondLastName}"})
    public Optional<Students> findStudentBySecondLastName(@PathVariable String secondLastName){ //Toma el valor dentro de los paréntesis como referencia para buscar los registros en la BD
        if(studentService.findByStudentSecondLastName(secondLastName).isEmpty()){ //Verifica si la segundo apellido ingresado dentro del método findByStudentSecondLastName no se encuentra vacía
            throw new RuntimeException("El segundo apellido ingresado no se encuentra registrado");//Excepción utilizada en tiempo de ejecución
        }
        return studentService.findByStudentSecondLastName(secondLastName); //Devuelve los registros que se relacionen con el segundo apellido del estudiante
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findStudentByGrade/{grade}"})
    public Optional<Students> findStudentByGrade(@PathVariable String grade){ //Toma el valor dentro de los paréntesis como referencia para buscar los registros en la BD
        if(studentService.findByStudentGrade(grade).isEmpty()){ //Verifica si el grado ingresada dentro del método findByStudentGrade no se encuentra vacía
            throw new RuntimeException("El grado del estudiante ingresado no se encuentra registrado");//Excepción utilizada en tiempo de ejecución
        }
        return studentService.findByStudentGrade(grade); //Devuelve los registros que se relacionen con el grado del estudiante
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findByStudentAge/{age}"})
    public Optional<Students> findByStudentAge(@PathVariable int age){ //Toma el valor dentro de los paréntesis como referencia para buscar los registros en la BD
        if(studentService.findByStudentAge(age).isEmpty()){ //Verifica si la edad ingresada dentro del método findByStudentAge no se encuentra vacía
            throw new RuntimeException("La edad ingresada del estudiante no ha sido registrada");//Excepción utilizada en tiempo de ejecución
        }
        return studentService.findByStudentAge(age); //Devuelve los registros que se relacionen con la edad del estudiante
    }

    /*El método Post mapping se utiliza para ingreso de datos que se le hayan ingresado en el package de entity en formato json*/
    @PostMapping({"/addStudents"})
    public Students addStudents(@RequestBody Students students){ //Toma el valor dentro de los paréntesis como referencia para buscar los registros en la BD
        if(students.getStudentName() == null || students.getStudentName().isEmpty()){ //Verifica que el nombre del estudiante no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un nombre");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentLastName() == null || students.getStudentLastName().isEmpty()){ //Verifica que el apellido del estudiante no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un apellido");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentSecondLastName() == null || students.getStudentSecondLastName().isEmpty()){ //Verifica que el segundo apellido del estudiante no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un segundo apellido");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentAge() >= 5 && students.getStudentAge() <= 12){ //Verifica que la edad del estudiante no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar una edad");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentEmail() == null || students.getStudentEmail().isEmpty()){ //Verifica que el email del estudiante no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un email");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentGrade() == null || students.getStudentGrade().isEmpty()){ //Verifica que el grado del estudiante no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un nivel de grado");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentAddress() == null || students.getStudentAddress().isEmpty()){ //Verifica que la dirección del hogar del estudiante no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar una dirección");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentTelephoneNumber() == null || students.getStudentTelephoneNumber().isEmpty()){ //Verifica que el número telefónico del estudiante no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un número telefónico");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentTeacherInCharge() == null || students.getStudentTeacherInCharge().isEmpty()){ //Verifica que el nombre del profesor encargado no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un profesor encargado");//Excepción utilizada en tiempo de ejecución
        }
        return studentService.addStudent(students); //Devuelve los datos ingresados si no se presentan inconvenientes
    }

    /*el método put mapping se utiliza para mapear solicitudes de tipo HTTP a diferencia del Post se utiliza para una actualización de datos ingresando el valor del id generado por la BD*/
    @PutMapping({"/updateStudents/{id}"}) // Se crea una ruta dentro del método Put Mapping donde le especifica el nombre de la url que tendrá y el parámetro de tipo id que se encuentra dentro de la BD
    //Se utiliza una función de tipo Students para poder utilizar el servicio ingresado para actualizar los datos con un id por defecto
    public Students updateStudents(@PathVariable Long id,@RequestBody Students students) { //utiliza el id como referencia para buscar un id específico y toma el valor dentro de los paréntesis como referencia para buscar actualizar datos en la BD
        if(students.getStudentName().isEmpty()){ //Verifica que el nombre del estudiante no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un nombre");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentLastName().isEmpty()){ //Verifica que el apellido del estudiante no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un apellido");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentSecondLastName().isEmpty()){ //Verifica que el segundo apellido del estudiante no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un segundo apellido");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentAge() < 5 || students.getStudentAge() > 12){ //Verifica que la edad del estudiante no sea menor 5 y mayor a 12 años
            throw new RuntimeException("Para actualizar debe ingresar una edad");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentEmail().isEmpty()){ //Verifica que el email del estudiante no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un email");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentGrade().isEmpty()){ //Verifica que el grado del estudiante no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un nivel de grado");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentAddress().isEmpty()){ //Verifica que el email del estudiante no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar una dirección");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentTelephoneNumber().isEmpty()){ //Verifica que el número telefónico no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un número telefónico");//Excepción utilizada en tiempo de ejecución
        }
        if(students.getStudentTeacherInCharge().isEmpty()){ //Verifica que el profesor encargado del estudiante no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un profesor encargado");//Excepción utilizada en tiempo de ejecución
        }
        return studentService.updateStudent(id, students); //Devuelve los datos ingresados si no se presentan inconvenientes
    }

    /*el método delete mapping se utiliza para eliminar registros ingresados en una base de datos dependiendo del valor que se le envie dentro de la ruta*/
    @DeleteMapping({"/deleteStudents/{id}"}) //En la ruta se pasa el valor de id el cual será utilizado para eliminar el registro ingresado el base de datos generado desde el package entity
    public String deleteStudents(@PathVariable Long id){ //Se utiliza un PathVariable para tomar de referencia el id para eliminar el registro ingresado
        studentService.deleteStudent(id); //busca dentro del studentService el parámetro dentro de la función deleteStudent el parámetro id para eliminar dicho regsitro
        return "Estudiante eliminado con éxito"; //Mostrará el mensaje de que se elimino correctamente el registro indicado por el id
    }
}
