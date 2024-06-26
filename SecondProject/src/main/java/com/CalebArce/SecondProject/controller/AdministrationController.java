package com.CalebArce.SecondProject.controller;


import com.CalebArce.SecondProject.entity.Administration;
import com.CalebArce.SecondProject.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdministrationController {

    @Autowired
    AdministrationService administrationService;

    @GetMapping({"/showAllAdmin"})
    public List<Administration> showAllAdmin(){
        if(administrationService.showAdministration().isEmpty()){
            throw new RuntimeException("No hay registro de personal administrativo");
        }
        return administrationService.showAdministration();
    }

    @GetMapping({"/findByName/{name}"})
    public Optional<Administration> findByName(@PathVariable String name){
        if(administrationService.findByName(name).isEmpty()){
            throw new RuntimeException("El nombre ingresado para el personal administrativo no se encuetra registrado");
        }
        return administrationService.findByName(name);
    }

    @GetMapping({"/findByLastName/{lastName}"})
    public Optional<Administration> findByLastName(@PathVariable String lastName){
        if(administrationService.findByLastName(lastName).isEmpty()){
            throw new RuntimeException("El apellido ingresado para el personal administrativo no se " +
                                        "encuetra registrado");
        }
        return administrationService.findByLastName(lastName);
    }

    @GetMapping({"/findBySecondLastName/{secondLastName}"})
    public Optional<Administration> findBySecondLastName(@PathVariable String secondLastName){
        if(administrationService.findBySecondLastName(secondLastName).isEmpty()){
            throw new RuntimeException("El segundo apellido ingresado para el personal administrativo " +
                                        "no se encuetra registrado");
        }
        return administrationService.findBySecondLastName(secondLastName);
    }

    @GetMapping({"/findByCode/{code}"})
    public Optional<Administration> findByCode(@PathVariable String code){
        if(administrationService.findByCode(code).isEmpty()){
            throw new RuntimeException("El código ingresado para el personal administrativo no se encuentra registrado");
        }
        return administrationService.findByCode(code);
    }

    @PostMapping({"/addPersonal"})
    public Administration addPersonal(@RequestBody Administration administration){
        if(administration.getName() == null || administration.getName().isEmpty()){
            throw new RuntimeException("Debe ingresar un nombre");
        }
        if(administration.getLastName() == null || administration.getLastName().isEmpty()){
            throw new RuntimeException("Debe ingresar un apellido");
        }
        if(administration.getSecondLastName() == null || administration.getSecondLastName().isEmpty()){
            throw new RuntimeException("Debe ingresar un segundo apellido");
        }
        if(administration.getCode() == null || administration.getCode().isEmpty()){
            throw new RuntimeException("Debe ingresar un codigo");
        }
        if(administration.getSchool() == null || administration.getSchool().isEmpty()){
            throw new RuntimeException("Debe ingresar un centro educativo");
        }
        if(administration.getProvince() == null || administration.getProvince().isEmpty()){
            throw new RuntimeException("Debe ingresar una provincia");
        }
        if(administration.getCity() == null || administration.getCity().isEmpty()){
            throw new RuntimeException("Debe ingresar una cantón");
        }
        if(administration.getDistrict() == null || administration.getDistrict().isEmpty()){
            throw new RuntimeException("Debe ingresar un distrito");
        }
        if(administration.getPosition() == null || administration.getPosition().isEmpty()){
            throw new RuntimeException("Debe ingresar un puesto laboral");
        }
        if(administration.getEmail() == null || administration.getEmail().isEmpty()){
            throw new RuntimeException("Debe ingresar un email");
        }
        if(administration.getTelephoneNumber() == null || administration.getTelephoneNumber().isEmpty()){
            throw new RuntimeException("Debe ingresar un número de teléfono");
        }
        return administrationService.addPersonal(administration);
    }

    @PutMapping({"/updatePersonal/{id}"})
    public Administration updatePersonal(@PathVariable Long id, @RequestBody Administration administration){
        if(administration.getName() == null || administration.getName().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un nombre");
        }
        if(administration.getLastName() == null || administration.getLastName().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un apellido");
        }
        if(administration.getSecondLastName() == null || administration.getSecondLastName().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un segundo apellido");
        }
        if(administration.getCode() == null || administration.getCode().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un código");
        }
        if(administration.getSchool() == null || administration.getSchool().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un centro educativo");
        }
        if(administration.getPosition() == null || administration.getPosition().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un puesto laboral");
        }
        if(administration.getEmail() == null || administration.getEmail().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un email");
        }
        if(administration.getTelephoneNumber() == null || administration.getTelephoneNumber().isEmpty()){
            throw new RuntimeException("Para actualizar debe ingresar un número de teléfono");
        }
        return administrationService.updateAdministration(id, administration);
    }

    @DeleteMapping({"/deletePersonal/{id}"})
    public String deletePersonal(@PathVariable Long id){
        return "Personal eliminado con éxito";
    }

}
