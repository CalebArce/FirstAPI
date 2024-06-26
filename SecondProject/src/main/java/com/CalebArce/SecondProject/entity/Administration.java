package com.CalebArce.SecondProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_administration")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Administration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String secondLastName;
    private String position;
    private String email;
    private String province;
    private String city;
    private String district;
    private String school; /*Referencia a Centro educativo*/
    private String code;
    private String telephoneNumber;
}
