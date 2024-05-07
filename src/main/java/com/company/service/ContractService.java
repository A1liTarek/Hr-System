package com.company.service;

import com.company.model.Contract;
import com.company.repo.CompanyRepo;
import com.company.repo.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
    @Autowired
    private ContractRepo contractRepo;

    public Contract createContract(Contract contract){
        contractRepo.save(contract);
        return contract;

}
     public Contract updateContract(Contract contract){
        contractRepo.save(contract);
        return contract;
     }

     public Contract deleteAllContract(){
        contractRepo.deleteAll();
        return null;
     }

}

