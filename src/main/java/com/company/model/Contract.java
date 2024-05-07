package com.company.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity

public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contractNum;
    private String signDate;
    private String startDate;
    private String endDate;
    private String contractStage;

    @OneToOne(mappedBy = "contract")
    private Employee employee;







}
