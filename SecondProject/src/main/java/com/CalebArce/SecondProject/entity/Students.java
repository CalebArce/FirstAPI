package com.CalebArce.SecondProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String studentName;
    private String studentLastName;
    private String studentSecondLastName;
    private String studentAge;
    private String studentEmail;
    private String studentGrade;
    private String studentTeacherInCharge;
    private String studentAddress;
    private String studentTelephoneNumber;
}
