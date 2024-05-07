package com.company.controller;

import com.company.model.Department;
import com.company.model.Employee;
import com.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/depatrment")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<Department> createDepart(@RequestBody Department department){
        return ResponseEntity.ok(departmentService.createDepart(department));
    }
    @PutMapping("/update")
    public ResponseEntity<Department> updateDepart(@RequestBody Department department){
        return ResponseEntity.ok(departmentService.updateDepart(department));
    }
    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        departmentService.deleteAllDepart();
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<Department>searchName(@PathVariable String name){
        return ResponseEntity.ok(departmentService.searchByName(name));
    }

}
