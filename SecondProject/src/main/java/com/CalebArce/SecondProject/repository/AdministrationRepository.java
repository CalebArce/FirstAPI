package com.CalebArce.SecondProject.repository;

import com.CalebArce.SecondProject.entity.Administration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministrationRepository extends JpaRepository<Administration,Long> {


    @Query("SELECT a FROM Administration a WHERE a.name = :name")
    Optional<Administration> findByName(String name);

    @Query("SELECT a FROM Administration a WHERE a.lastName = :lastName")
    Optional<Administration> findByLastName(String lastName);

    @Query("SELECT a FROM Administration a WHERE a.secondLastName = :secondLastName")
    Optional<Administration> findBySecondLastName(String secondLastName);

    @Query("SELECT a FROM Administration a WHERE a.code = :code")
    Optional<Administration> findByCode(String code);
}
