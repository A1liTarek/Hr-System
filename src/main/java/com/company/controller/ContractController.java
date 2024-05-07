package com.company.controller;

import com.company.model.Contract;
import com.company.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contract")
public class ContractController {
@Autowired
    private ContractService contractService;
   @PostMapping("/create")
   public ResponseEntity<Contract>craeteContract(@RequestBody Contract contract){
     return   ResponseEntity.ok(contractService.createContract(contract));
   }
   @PutMapping("/update")
    public ResponseEntity<Contract>updateContract(@RequestBody Contract contract){
       return ResponseEntity.ok(contractService.updateContract(contract));
   }

   @DeleteMapping("/delete")
    public void deleteAllContract(){
       contractService.deleteAllContract();
   }
}
