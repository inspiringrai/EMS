package com.demo.EMS.Repository;

import com.demo.EMS.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
