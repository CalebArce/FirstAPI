package com.CalebArce.SecondProject.controller;


import com.CalebArce.SecondProject.entity.Administration;
import com.CalebArce.SecondProject.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdministrationController {

    /*Se utiliza para la inyección de dependencias*/
    @Autowired
    AdministrationService administrationService;

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creado*/
    @GetMapping({"/showAllAdmin"})
    public List<Administration> showAllAdmin(){ //Muestra el registro completo almacenado dentro de una lista de tipo Administration del package entity para mostrar los registros
        if(administrationService.showAdministration().isEmpty()){
            throw new RuntimeException("No hay registro de personal administrativo");
        }
        return administrationService.showAdministration();
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creador e incluso ingresando una variable de referencia*/
    @GetMapping({"/findByName/{name}"})
    public Optional<Administration> findByName(@PathVariable String name){ //Se le indica en la ruta que obtendra un valor de tipo name que es el que se espera buscar para buscar un registro completo
        if(administrationService.findByName(name).isEmpty()){
            throw new RuntimeException("El nombre ingresado para el personal administrativo no se encuetra registrado");
        }
        return administrationService.findByName(name);
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creador e incluso ingresando una variable de referencia*/
    @GetMapping({"/findByLastName/{lastName}"})
    public Optional<Administration> findByLastName(@PathVariable String lastName){ //Se le indica en la ruta que obtendra un valor de tipo lastName que es el que se espera buscar para buscar un registro completo
        if(administrationService.findByLastName(lastName).isEmpty()){
            throw new RuntimeException("El apellido ingresado para el personal administrativo no se " +
                                        "encuetra registrado");
        }
        return administrationService.findByLastName(lastName);
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creador e incluso ingresando una variable de referencia*/
    @GetMapping({"/findBySecondLastName/{secondLastName}"}) //Se le indica en la ruta que obtendra un valor de tipo secondLastName que es el que se espera buscar para buscar un registro completo
    public Optional<Administration> findBySecondLastName(@PathVariable String secondLastName){
        if(administrationService.findBySecondLastName(secondLastName).isEmpty()){
            throw new RuntimeException("El segundo apellido ingresado para el personal administrativo " +
                                        "no se encuetra registrado");
        }
        return administrationService.findBySecondLastName(secondLastName);
    }

    /*El método get mapping se utiliza solamente para mostrar los datos ingresados a una base de datos u objeto creador e incluso ingresando una variable de referencia*/
    @GetMapping({"/findByCode/{code}"}) //Se le indica en la ruta que obtendra un valor de tipo code que es el que se espera buscar para buscar un registro completo
    public Optional<Administration> findByCode(@PathVariable String code){
        if(administrationService.findByCode(code).isEmpty()){
            throw new RuntimeException("El código ingresado para el personal administrativo no se encuentra registrado");
        }
        return administrationService.findByCode(code);
    }


    /*El método Post mapping se utiliza para ingreso de datos que se le hayan ingresado en el package de entity en formato json*/
    @PostMapping({"/addPersonal"})
    public Administration addPersonal(@RequestBody Administration administration){
        if(administration.getName() == null || administration.getName().isEmpty()){//Verifica que el nombre del trabajador no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un nombre");//Excepción manejada dentro del package error
        }
        if(administration.getLastName() == null || administration.getLastName().isEmpty()){ //Verifica que el apellido del trabajador no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un apellido");//Excepción manejada dentro del package error
        }
        if(administration.getSecondLastName() == null || administration.getSecondLastName().isEmpty()){ //Verifica que el segundo apellido del trabajador no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un segundo apellido");//Excepción manejada dentro del package error
        }
        if(administration.getCode() == null || administration.getCode().isEmpty()){ //Verifica que el código del trabajador no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un codigo");//Excepción manejada dentro del package error
        }
        if(administration.getSchool() == null || administration.getSchool().isEmpty()){ //Verifica que el centro educativo donde laboran no esté nulo ni vacío
            throw new RuntimeException("Debe ingresar un centro educativo");//Excepción manejada dentro del package error
        }
        if(administration.getProvince() == null || administration.getProvince().isEmpty()){ //Verifica que la provincia del centro educativo no sea nula ni esté vacía
            throw new RuntimeException("Debe ingresar una provincia");//Excepción manejada dentro del package error
        }
        if(administration.getCity() == null || administration.getCity().isEmpty()){ //Verifica que el cantón del centro educativo no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar una cantón");//Excepción manejada dentro del package error
        }
        if(administration.getDistrict() == null || administration.getDistrict().isEmpty()){ //Verifica que el distrito del centro educativo no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un distrito");//Excepción manejada dentro del package error
        }
        if(administration.getPosition() == null || administration.getPosition().isEmpty()){ //Verifica que el puesto laboral no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un puesto laboral");//Excepción manejada dentro del package error
        }
        if(administration.getEmail() == null || administration.getEmail().isEmpty()){ //Verifica que el email laboral no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un email");//Excepción manejada dentro del package error
        }
        if(administration.getTelephoneNumber() == null || administration.getTelephoneNumber().isEmpty()){ //Verifica que el número telefónico no sea nulo ni esté vacío
            throw new RuntimeException("Debe ingresar un número de teléfono");//Excepción manejada dentro del package error
        }
        return administrationService.addPersonal(administration); //Almacena los datos ingresados si no inconvenientes
    }

    /*el método put mapping se utiliza para mapear solicitudes de tipo HTTP a diferencia del Post se utiliza para una actualización de datos ingresando el valor del id generado por la BD*/
    @PutMapping({"/updatePersonal/{id}"}) // Se crea una ruta dentro del método Put Mapping donde le especifica el nombre de la url que tendrá y el parámetro de tipo id que se encuentra dentro de la BD
    //Se utiliza una función de tipo Administration para poder utilizar el servicio ingresado para actualizar los datos con un id por defecto
    public Administration updatePersonal(@PathVariable Long id, @RequestBody Administration administration){
        if(administration.getName().isEmpty()){ //Verifica que el nombre del trabajador no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un nombre");//Excepción manejada dentro del package error
        }
        if(administration.getLastName().isEmpty()){ //Verifica que el apellido del trabajador no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un apellido");//Excepción manejada dentro del package error
        }
        if(administration.getSecondLastName().isEmpty()){ //Verifica que el segundo apellido del trabajador no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un segundo apellido");//Excepción manejada dentro del package error
        }
        if(administration.getCode().isEmpty()){ //Verifica que el código del trabajador no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un código");//Excepción manejada dentro del package error
        }
        if(administration.getSchool().isEmpty()){ //Verifica que el centro educativo donde laboran no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un centro educativo");//Excepción manejada dentro del package error
        }
        if(administration.getPosition().isEmpty()){ //Verifica que el puesto laboral no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un puesto laboral");//Excepción manejada dentro del package error
        }
        if(administration.getEmail().isEmpty()){ //Verifica que el email laboral no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un email");//Excepción manejada dentro del package error
        }
        if(administration.getTelephoneNumber().isEmpty()){ //Verifica que el número telefónico no esté vacío
            throw new RuntimeException("Para actualizar debe ingresar un número de teléfono");//Excepción manejada dentro del package error
        }
        return administrationService.updateAdministration(id, administration);
    }

    /*el método delete mapping se utiliza para eliminar registros ingresados en una base de datos dependiendo del valor que se le envie dentro de la ruta*/
    @DeleteMapping({"/deletePersonal/{id}"}) //En la ruta se pasa el valor de id el cual será utilizado para eliminar el registro ingresado el base de datos generado desde el package entity
    public String deletePersonal(@PathVariable Long id){ //Se utiliza un PathVariable para tomar de referencia el id para eliminar el registro ingresado
        administrationService.deleteAdministration(id); //Busca dentro del administrationService el parámetro dentro de la función deleteAdministration el parámetro id para eliminar dicho regsitro
        return "Personal eliminado con éxito"; //Mostrará el mensaje de que se elimino correctamente el registro indicado por el id
    }

}
