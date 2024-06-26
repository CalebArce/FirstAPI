package com.CalebArce.SecondProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_schools")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*1*/private Long id;
    /*2*/private String schoolName;
    /*3*/private String schoolProvince;
    /*4*/private String schoolCity;
    /*5*/private String schoolDistrict;
    /*6*/private String schoolEmail;
    /*7*/private String schoolTelephoneNumber;
    /*8*/private String schoolCode;
    /*9*/private int schoolQuantityStudents;
    /*10*/private int schoolQuantityTeachers;
}
