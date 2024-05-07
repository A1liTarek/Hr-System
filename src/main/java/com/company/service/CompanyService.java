package com.company.service;

import com.company.model.Company;
import com.company.model.Department;
import com.company.model.Employee;
import com.company.repo.CompanyRepo;
import com.company.repo.DepartmentRepo;
import com.company.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Service

public class CompanyService {
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentRepo departmentRepo;


    public Company creatCompany(Company company){
        companyRepo.save(company);
        return company;
    }
    public Company updateCompany (Company company){
        companyRepo.save(company);
        return company;
    }
    public List<Company> getAll(){
        return companyRepo.findAll();
    }

    public void deleteAll(){
        companyRepo.deleteAll();
    }

    public Company getById(Long id){
       companyRepo.findById(id);
        Optional<Company> company=companyRepo.findById(id);
        return company.orElse(null);
    }
    public void delById(Long id){
       Company company=getById(id);
       companyRepo.deleteById(id);
    }
    public Employee signEmpToCom(Employee employee, Long id){
        employeeService.createEmp(employee);
        Company com=getById(id);
        employee.setCompanyId(id);
        companyRepo.save(com);
        return employee;
    }

    public void assignReassign(Long empId,Long companyId){
        Employee employee=employeeRepo.findById(empId).orElseThrow(()->new
                RuntimeException("EMP_NOT_FOUNDED"));
        if(Objects.nonNull(companyId)){
            employee.setCompanyId(companyId);
        }else
            employee.setCompanyId(null);
        employeeRepo.save(employee);
    }
    public Company searchByName(String name){
        Optional<Company>company= companyRepo.findByNameContaining(name);
        return company.orElse(null);

    }
       public void assignDepartToCompany(Long deptNo ,Long companyId){
           Department department=departmentRepo.findById(deptNo).orElseThrow(() ->new
                   RuntimeException("DEPARTMENT_NOT_FOUND"));
           if (Objects.nonNull(companyId)){
               department.setCompany(companyRepo.getById(companyId));
           }else
               department.setCompany(null);
           departmentRepo.save(department);

       }


}
