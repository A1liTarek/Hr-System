package com.company.controller;

import com.company.model.Employee;
import com.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//http://localhost:8080/Employee
@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;
    @PostMapping("/create")
    public ResponseEntity<Employee>createEmp(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.createEmp(employee));
    }
    @PutMapping("/update")
    public ResponseEntity<Employee>updateEmp(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.update(employee));
    }
    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        employeeService.deleteAll();
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAllEmp());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Employee>getEmpId(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmp(id));
    }
    @DeleteMapping("/del/{id}")
    public void deleteEmp(@PathVariable Long id){
        employeeService.delById(id);
    }


    @GetMapping("/search/{name}")
    public ResponseEntity<Employee>searchName(@PathVariable String name){
        return ResponseEntity.ok(employeeService.searchByName(name));
    }
    @PutMapping("/netSallary/{empid}")
    public ResponseEntity calculateNetSallary(@PathVariable Long empId){
        return ResponseEntity.ok(employeeService.calculateNetSallary(empId));
    }
    @PutMapping("/rate/{empid}")
    public ResponseEntity<Employee>rateEmployee(@PathVariable Long empid,int pass,String rate){
        return ResponseEntity.ok(employeeService.managerRate(empid,pass,rate));
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<Employee>searchName(@PathVariable String name){
        return ResponseEntity.ok(employeeService.searchByName(name));
    }
    @GetMapping("/findhighovertime")
    public ResponseEntity<Employee>findHighOverTime(){
        return ResponseEntity.ok(employeeService.findEmpWithHighOverTime());
    }
}

