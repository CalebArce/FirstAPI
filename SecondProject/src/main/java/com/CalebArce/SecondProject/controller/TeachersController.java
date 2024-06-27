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

    /*La anotación get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado*/
    @GetMapping({"/findAllTeachers"})
    public List<Teachers> findAllTeachers(){
        if(teacherService.showAllTeachers().isEmpty()){ //Verifica que no esté vacía la lista para mostrar todos los registros
            throw new RuntimeException("No hay registro de profesores");//Excepción manejada dentro del package error
        }
        return teacherService.showAllTeachers(); //Devuelve los registros que se ingresaron
    }

    /*La anotación get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findTeacherByName/{name}"})
    public Optional<Teachers> findTeacherByName(@PathVariable String name){ //utiliza el nombre como referencia para buscar un registro relacionado en la BD
        if(teacherService.findTeacherByName(name).isEmpty()){ //Verifica que no esté vacío el nombre
            throw new RuntimeException("El nombre del profesor ingresado no se encuentra registrado");//Excepción utilizada en tiempo de ejecución
        }
        return teacherService.findTeacherByName(name); //Devuelve los registros que se relacionen con el nombre del profesores
    }

    /*La anotación get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findTeacherByLastName/{lastName}"})
    public Optional<Teachers> findTeacherByLastName(@PathVariable String lastName){ //utiliza el primer apellido como referencia para buscar un registro relacionado en la BD
        if(teacherService.findTeacherByLastName(lastName).isEmpty()){ //Verifica que no esté vacío el primer apellido
            throw new RuntimeException("El apellido del profesor ingresado no se encuentra registrado");//Excepción utilizada en tiempo de ejecución
        }
        return teacherService.findTeacherByLastName(lastName); //Devuelve los registros que se relacionen con el primer apellido del profesores
    }

    /*La anotación get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findTeacherBySecondLastName/{secondLastName}"})
    public Optional<Teachers> findTeacherBySecondLastName(@PathVariable String secondLastName){//utiliza el segundo apellido como referencia para buscar un registro relacionado en la BD
        if(teacherService.findTeacherBySecondLastName(secondLastName).isEmpty()){ //Verifica que no esté vacío el segundo apellido
            throw new RuntimeException("El segundo apellido del profesor ingresado no se encuentra registrado");//Excepción utilizada en tiempo de ejecución
        }
        return teacherService.findTeacherBySecondLastName(secondLastName);//Devuelve los registros que se relacionen con el segundo apellido del profesores
    }

    /*La anotación get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping("/findTeacherByJobLicense/{jobLicense}")
    public Optional<Teachers> findTeacherByJobLicense(@PathVariable String jobLicense){ //utiliza el gafete como referencia para buscar un registro específico en la BD
        if(teacherService.findTeacherByJobLicense(jobLicense).isEmpty()){ //Verifica que no esté vacío el número de gafete
            throw new RuntimeException("El número de gafete del profesor ingresado no se encuentra registrado");//Excepción utilizada en tiempo de ejecución
        }
        return teacherService.findTeacherByJobLicense(jobLicense);//Devuelve los registros que se relacionen con el número de gafete del profesor
    }

    /*La anotación get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado e incluso ingresando una variable de referencia*/
    @GetMapping({"/findTeacherBySignature/{signature}"})
    public Optional<Teachers> findTeacherBySignature(@PathVariable String signature){//utiliza la asignatura como referencia para buscar un registro relacionado en la BD
        if(teacherService.findTeacherBySignature(signature).isEmpty()){ //Verifica que no esté vacía la asignatura
            throw new RuntimeException("La asignatura ingresada para el profesor no se encuentra registrada");//Excepción utilizada en tiempo de ejecución
        }
        return teacherService.findTeacherBySignature(signature); //devuelve el registro de las asignaturas por profesor
    }

    /*La anotación Post mapping se utiliza para ingreso de datos que se le hayan ingresado en el package de entity en formato json*/
    @PostMapping({"/addTeachers"})
    public Teachers addTeachers(@RequestBody Teachers teachers){ //Utiliza el request body para anotar los argumentos de métodos de controladores de solicitudes
        if(teachers.getTeacherName() == null || teachers.getTeacherName().isEmpty()){ //Verifica que el nombre del profesor no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un nombre");//Excepción utilizada en tiempo de ejecución
        }
        if(teachers.getTeacherLastName() == null || teachers.getTeacherLastName().isEmpty()){ // Verifica que el primer apellido no esté nulo ni vacío
            throw new RuntimeException("Debe ingresar un apellido");//Excepción utilizada en tiempo de ejecución
        }
        if(teachers.getTeacherSecondLastName() == null || teachers.getTeacherSecondLastName().isEmpty()){ //Verifica que el segudno apellido no esté nulo ni vacío
            throw new RuntimeException("Debe ingresar segundo un apellido");//Excepción utilizada en tiempo de ejecución
        }
        if(teachers.getTeacherEmail() == null || teachers.getTeacherEmail().isEmpty()){ //Verifica que el email del profesor no sea nilo ni esté vacío
            throw new RuntimeException("Debe ingresar un email");//Excepción utilizada en tiempo de ejecución
        }
        if(teachers.getTeacherJobLicense() == null || teachers.getTeacherJobLicense().isEmpty()){ //Verifica que el gafete del profesor no esté nulo ni vacío
            throw new RuntimeException("Debe ingresar un número de gafete");//Excepción utilizada en tiempo de ejecución
        }
        if(teachers.getTeacherTelephoneNumber() == null || teachers.getTeacherTelephoneNumber().isEmpty()){ // Verifica que el número telefónico del profesor no esté nulo ni vacío
            throw new RuntimeException("Debe ingresar un número de teléfono");//Excepción utilizada en tiempo de ejecución
        }
        if(teachers.getTeacherSignature() == null || teachers.getTeacherSignature().isEmpty()){ //Verifica que la asignatura del profesor no esté nula ni vacía
            throw new RuntimeException("Debe ingresar la asignatura del profesor");//Excepción utilizada en tiempo de ejecución
        }
        return teacherService.addTeacher(teachers); //devuelve el registro del ingreso en formato JSON
    }

    /*La anotación put mapping se utiliza para mapear solicitudes de tipo HTTP a diferencia del Post se utiliza para una actualización de datos ingresando el valor del id generado por la BD*/
    @PutMapping({"/updateTeachers/{id}"}) // Se crea una ruta dentro del método Put Mapping donde le especifica el nombre de la url que tendrá y el parámetro de tipo id que se encuentra dentro de la BD
    //Se utiliza una función de tipo Teachers para poder utilizar el servicio ingresado para actualizar los datos con un id por defecto
    public Teachers updateTeachers(@PathVariable Long id,@RequestBody Teachers teachers){//utiliza el id como referencia para buscar un id específico y toma el valor dentro de los paréntesis como referencia para buscar actualizar datos en la BD
        if(teachers.getTeacherName().isEmpty()){ //Verifica que el nombre del profesor no esté vacío
            throw new RuntimeException("Para actualizar datos debe ingresar un nombre");//Excepción utilizada en tiempo de ejecución
        }
        if(teachers.getTeacherLastName().isEmpty()){ //Verifica que el primer apellido del profesor no esté vacío
            throw new RuntimeException("Para actualizar datos debe ingresar un apellido");//Excepción utilizada en tiempo de ejecución
        }
        if(teachers.getTeacherSecondLastName().isEmpty()){ //Verifica que el segundo apellido del profesor no esté vacío
            throw new RuntimeException("Para actualizar datos debe ingresar segundo un apellido");//Excepción utilizada en tiempo de ejecución
        }
        if(teachers.getTeacherEmail().isEmpty()){ //Verifica que el email del profesor no esté vacío
            throw new RuntimeException("Para actualizar datos debe ingresar un email");//Excepción utilizada en tiempo de ejecución
        }
        if(teachers.getTeacherJobLicense().isEmpty()){ //Verifica que el número de gafete del profesor no esté vacío
            throw new RuntimeException("Para actualizar datos debe ingresar un número de gafete");//Excepción utilizada en tiempo de ejecución
        }
        if(teachers.getTeacherTelephoneNumber().isEmpty()){ //Verifica que el número telefónico del profesor no esté vacío
            throw new RuntimeException("Para actualizar datos debe ingresar un número de teléfono");//Excepción utilizada en tiempo de ejecución
        }
        if(teachers.getTeacherSignature().isEmpty()){ //Verifica que la asignatura del profesor no esté vacío
            throw new RuntimeException("Para actualizar datos debe ingresar la asignatura del profesor");//Excepción utilizada en tiempo de ejecución
        }
        return teacherService.updateTeacher(id,teachers);//devuelve una actualización del registro ya ingresado en formato JSON
    }

    /*La anotación delete mapping se utiliza para eliminar registros ingresados en una base de datos dependiendo del valor que se le envie dentro de la ruta*/
    @DeleteMapping({"/deleteTeachers/{id}"}) //En la ruta se pasa el valor de id el cual será utilizado para eliminar el registro ingresado el base de datos generado desde el package entity
    public String deleteTeachers(@PathVariable Long id){ //Se utiliza un PathVariable para tomar de referencia el id para eliminar el registro ingresado
        teacherService.deleteTeacher(id); //Busca dentro del teacherService el parámetro dentro de la función deleteTeacher el parámetro id para eliminar dicho regsitro
        return "Educador eliminador con éxito"; //Mostrará el mensaje de que se elimino correctamente el registro indicado por el id
    }
}
