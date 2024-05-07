package com.company.service;

import com.company.model.Company;
import com.company.model.Department;
import com.company.model.Employee;
import com.company.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;
    public Department createDepart(Department department){
        departmentRepo.save(department);
        return department;
    }
    public Department updateDepart(Department department){
        departmentRepo.save(department);
        return department;
    }
    public Department deleteAllDepart(){
        departmentRepo.deleteAll();
        return null;
    }
    public Department searchByName(String name){
        Optional<Department> department= departmentRepo.findByDeptNameContaining(name);
        return department.orElse(null);

    }
    public Department getById(Long id){
        departmentRepo.findById(id);
        Optional<Department> department=departmentRepo.findById(id);
        return department.orElse(null);
    }



}
