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
    /*1*/private Long id;
    /*2*/private String studentName;
    /*3*/private String studentLastName;
    /*4*/private String studentSecondLastName;
    /*5*/private String studentAge;
    /*6*/private String studentEmail;
    /*7*/private String studentGrade;
    /*8*/private String studentTeacherInCharge;
    /*9*/private String studentAddress;
    /*10*/private String studentTelephoneNumber;
}
