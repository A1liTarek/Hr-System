package com.company.repo;

import com.company.model.Department;
import com.sun.jdi.DoubleValue;
import com.sun.jdi.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
    Optional<Department>findByDeptNameContaining(String name);

    @Query("SELECT d FROM Department d where d.sales=(SELECT MAX (d.sales)FROM Department d)")
    Optional<Department>findHighSales();

}
