package com.company.controller;

import com.company.model.Company;
import com.company.model.Employee;
import com.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//http://localhost:8080/company
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping("/create")
    public ResponseEntity<Company> createCom(@RequestBody Company company){
       return ResponseEntity.ok(companyService.creatCompany(company));
    }
    @PutMapping("/update")
    public ResponseEntity<Company>updateCom(@RequestBody Company company){
        return ResponseEntity.ok(companyService.updateCompany(company));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Company>>getAllCom(){
        return ResponseEntity.ok(companyService.getAll());
    }
    @DeleteMapping("/dellAll")
    public void dellAllCom(){
        companyService.deleteAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Company>getIdCom(@PathVariable Long id){
        return ResponseEntity.ok(companyService.getById(id));
    }
    @DeleteMapping("/del/{id}")
    public void dellIdCom(@PathVariable Long id){
        companyService.delById(id);
    }

    @GetMapping("/assign-reassign/{empId}")
    public ResponseEntity<?> assignReassign(@PathVariable Long empId,@RequestParam(required = false) Long companyId){
        companyService.assignReassign(empId,companyId);
        return  ResponseEntity.ok(HttpMessage.class);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<Company>searchName(@PathVariable String name){
        return ResponseEntity.ok(companyService.searchByName(name));
    }
    @GetMapping("/assign/{deptNo}")
    public ResponseEntity<?>assignDeptToCompany(@PathVariable Long deptNo,Long companyId){
        companyService.assignDepartToCompany(deptNo,companyId);
       return ResponseEntity.ok(HttpMessage.class);
    }



}