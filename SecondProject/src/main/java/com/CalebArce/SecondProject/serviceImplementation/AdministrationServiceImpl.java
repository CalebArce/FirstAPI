package com.CalebArce.SecondProject.serviceImplementation;

import com.CalebArce.SecondProject.entity.Administration;
import com.CalebArce.SecondProject.repository.AdministrationRepository;
import com.CalebArce.SecondProject.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrationServiceImpl implements AdministrationService {
    @Autowired
    AdministrationRepository administrationRepository;

    @Override
    public List<Administration> showAdministration() {
        return administrationRepository.findAll();
    }

    @Override
    public Administration addPersonal(Administration administration) {
        return administrationRepository.save(administration);
    }

    @Override
    public Administration updateAdministration(Long id,Administration administration) {
        Administration adminDB = administrationRepository.findById(id).get();
        return administrationRepository.save(adminDB);
    }

    @Override
    public String deleteAdministration(Long id) {
        Administration adminDB = administrationRepository.findById(id).get();
        return "Laborador eliminado";
    }

    @Override
    public Optional<Administration> findByName(String name) {
        return administrationRepository.findByName(name);
    }

    @Override
    public Optional<Administration> findByLastName(String lastName) {
        return administrationRepository.findByLastName(lastName);
    }

    @Override
    public Optional<Administration> findBySecondLastName(String secondLastName) {
        return administrationRepository.findBySecondLastName(secondLastName);
    }

    @Override
    public Optional<Administration> findByCode(String code) {
        return administrationRepository.findByCode(code);
    }
}
