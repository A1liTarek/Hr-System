package com.company.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long deptNO;
    private String deptName;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
    @ManyToOne
    @JoinColumn(name="company_id",insertable = false,updatable = false)
    private Company company;

}
