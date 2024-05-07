package com.company.service;

import com.company.model.Company;
import com.company.model.Employee;
import com.company.model.enums.Level;
import com.company.repo.CompanyRepo;
import com.company.repo.EmployeeRepo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Logger;

@Service
@Log4j
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private CompanyRepo companyRepo;

    private Logger logger;


    public Employee createEmp(Employee  employee){
        employeeRepo.save(employee);
        return employee;
    }

    public Employee update(Employee employee) {
        employeeRepo.save(employee);
        return employee;
    }

    public List<Employee> getAllEmp(){

        return employeeRepo.findAll();
    }

    public Employee getEmp(Long id){
        Optional<Employee> employee=employeeRepo.findById(id);
        return employee.orElse(null);
    }
    public void delById(Long id){
        Employee employee=getEmp(id);
        employeeRepo.deleteById(id);
    }
    public void deleteAll(){
        employeeRepo.deleteAll();
    }

    public Employee searchByName(String name){
       Optional<Employee>employee= employeeRepo.findByNameContaining(name);
       return employee.orElse(null);

    }
    public Employee calculateNetSallary(Long empId) {
        Employee employee = getEmp(empId);
        if (employee.getLate() <= employee.getHolidays()) {
            employee.setNetsallary(employee.getGrosssallary() - (employee.getGrosssallary() * .02));
        } else {
            int fine = (employee.getLate() - employee.getHolidays()) * 500;
            employee.setNetsallary(employee.getGrosssallary() - (employee.getGrosssallary() * .02) - fine);

        }
        return employee;
    }


    public Employee managerRate(Long empId,int pass,String rate){

     //   System.out.print("welcome Manger pls ENTER UR pass");
        logger.info("welcome Manger pls ENTER UR pass");
        Scanner scanner=new Scanner(System.in);
      //  pass=scanner.nextInt();
        Employee employee=getEmp(empId);
        if(employee.getLevel().equals(Level.MANGER)){
            employee.setRate(rate);
            return employee;
        }else {
            System.out.println("SORRY");
            return null;

        }
    }
}






