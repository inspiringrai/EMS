package com.demo.EMS.controller;

import com.demo.EMS.Services.EmployeeService;
import com.demo.EMS.beans.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //display all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    //display employee by id
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    //insert into employee
    @PostMapping("/employees")
    public void addEmployees(@RequestBody Employee e){
         employeeService.addEmployee(e);
    }

    //updating employee by id
    @PutMapping("/employees/{id}")
    public void addEmployees(@RequestBody Employee e , @PathVariable int id){
        employeeService.updateEmployee(e,id);
    }

    //delete all employee
    @DeleteMapping("/employees")
    public void deleteAllEmployees(){
        employeeService.deleteAllEmployees();
    }

    //delete by employee id
    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeByID(@RequestBody Employee e , @PathVariable int id){
    employeeService.deleteEmployeeByID(id);
    }
}
