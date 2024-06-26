package com.CalebArce.SecondProject.service;

import com.CalebArce.SecondProject.entity.Administration;
import com.CalebArce.SecondProject.entity.School;
import com.CalebArce.SecondProject.entity.Students;
import com.CalebArce.SecondProject.entity.Teachers;

import java.util.List;
import java.util.Optional;

public interface AdministrationService {

    /*FORMATOS DE BÚSQUEDA,INGRESO,ACTUALIZACIÓN Y ELIMINACIÓN DE DATOS PARA EL CONTROLLER*/
    List<Administration> showAdministration();
    Administration addPersonal(Administration administration);
    Administration updateAdministration(Long id,Administration administration);
    String deleteAdministration(Long id);

    /*BÚSQUEDAS PARA ADMINISTRATION*/
    Optional<Administration> findByName(String name);
    Optional<Administration> findByLastName(String lastName);
    Optional<Administration> findBySecondLastName(String secondLastName);
    Optional<Administration> findByCode(String code);
}
