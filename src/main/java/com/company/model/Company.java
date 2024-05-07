package com.company.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String phone;
    private String Email;
    private String address;
    @OneToMany(mappedBy = "company")
    private List<Employee> employees;
    @OneToMany(mappedBy = "company")
    private List<Department> departments;
}

