package com.demo.EMS.Services;

import com.demo.EMS.Entity.Employee;
import com.demo.EMS.dto.AddEmployeeRequest;
import com.demo.EMS.dto.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeService {

   // fetching all employee
   List<Employee> getAllEmployees();

    // fetching employee by id
    Employee getEmployee(int id);

    // inserting employee
    Employee addEmployee(AddEmployeeRequest e) ;

    // updating employee by id
    Employee updateEmployee(UpdateEmployeeRequest emp, int id);

    // deleting all employees
    int deleteAllEmployees();

    // deleting employee by id
    boolean deleteEmployeeByID(int id);

}
