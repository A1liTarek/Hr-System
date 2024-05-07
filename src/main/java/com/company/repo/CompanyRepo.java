package com.company.repo;

import com.company.model.Company;
import com.company.model.Employee;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {
    Optional<Company> findByNameContaining(String name);
}
