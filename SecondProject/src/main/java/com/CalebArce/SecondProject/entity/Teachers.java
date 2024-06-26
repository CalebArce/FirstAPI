package com.CalebArce.SecondProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_teachers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teachers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String teacherName;
    private String teacherLastName;
    private String teacherSecondLastName;
    private String teacherEmail;
    private String teacherJobLicense;
    private String teacherTelephoneNumber;
    private String teacherSignature;
}
