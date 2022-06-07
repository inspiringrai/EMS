package com.demo.EMS.Repository;

import com.demo.EMS.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {

}
