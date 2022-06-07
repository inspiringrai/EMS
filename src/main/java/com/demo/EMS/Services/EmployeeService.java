package com.demo.EMS.Services;

import com.demo.EMS.beans.Employee;

import java.util.List;

public interface EmployeeService {

   // fetching all employee
   List<Employee> getAllEmployees();

    // fetching employee by id
    Employee getEmployee(int id);

    // inserting employee
    void addEmployee(Employee e) ;

    // updating employee by id
    void updateEmployee(Employee emp, int id);

    // deleting all employees
    void deleteAllEmployees();

    // deleting employee by id
    void deleteEmployeeByID(int id);

}
