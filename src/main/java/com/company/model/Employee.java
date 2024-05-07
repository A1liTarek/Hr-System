package com.company.model;

import com.company.model.enums.Job;
import com.company.model.enums.Level;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phone;
    private String Email;
    private double grosssallary;
    private double netsallary;

    @Enumerated(EnumType.ORDINAL)
    private Job job;


    @Enumerated(EnumType.ORDINAL)
    private Level level;
    private String gender;
    private String birthday;
    private String Depname;
    private int holidays;
    private int late;
    private String rate;
    @ManyToOne
    @JoinColumn(name="company_id",insertable = false,updatable = false)
    private Company company;
    @Column(name = "company_id")
    private Long companyId;
    @ManyToOne
    @JoinColumn(name="dept_id",insertable = false,updatable = false)
    private Department department;
    @Column(name = "dept_id")
    private Long deptNo;

    @OneToOne
    @JoinColumn(name = "contractNum")
    private Contract contract;

    public Employee() {
        this.setHolidays(21);
    }
}
