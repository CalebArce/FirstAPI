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
    private Long id;
    private String schoolName;
    private String schoolProvince;
    private String schoolCity;
    private String schoolDistrict;
    private String schoolEmail;
    private String schoolTelephoneNumber;
    private String schoolCode;
    private int schoolQuantityStudents;
    private int schoolQuantityTeachers;
}
