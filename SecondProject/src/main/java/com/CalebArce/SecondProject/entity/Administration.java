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
    /*1*/private Long id;
    /*2*/private String name;
    /*3*/private String lastName;
    /*4*/private String secondLastName;
    /*5*/private String position;
    /*6*/private String email;
    /*7*/private String province;
    /*8*/private String city;
    /*9*/private String district;
    /*10*/private String school; /*Referencia a Centro educativo*/
    /*11*/private String code;
    /*12*/private String telephoneNumber;
}
