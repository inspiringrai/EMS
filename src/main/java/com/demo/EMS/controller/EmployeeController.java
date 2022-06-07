package com.demo.EMS.controller;

import com.demo.EMS.Services.EmployeeService;
import com.demo.EMS.Entity.Employee;
import com.demo.EMS.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //display all employees
    @GetMapping("/employees")
    public ResponseEntity<GetAllEmployeeResponse> getAllEmployee(){
        List<Employee> allEmployees= employeeService.getAllEmployees();
        GetAllEmployeeResponse getAllEmployeeResponse=new GetAllEmployeeResponse(allEmployees,"All the currently working employees : ");
        return ResponseEntity.ok(getAllEmployeeResponse);
        //return employeeService.getAllEmployees();
    }

    //display employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<GetEmployeeByIdResponse> getEmployee(@PathVariable int id){
        //return employeeService.getEmployee(id);
        Employee emp=employeeService.getEmployee(id);
        if(emp==null)
        {
            GetEmployeeByIdResponse getEmployeeByIdResponse= new GetEmployeeByIdResponse(emp,"No employee found!!!!!");
            return ResponseEntity.ok(getEmployeeByIdResponse);
        }
        else{

            GetEmployeeByIdResponse getEmployeeByIdResponse=new GetEmployeeByIdResponse(emp,"Employee Details");
            return ResponseEntity.ok(getEmployeeByIdResponse);

        }
    }

    //insert into employee
    @PostMapping("/employees")
    //public void addEmployees(@RequestBody Employee e){
      //   employeeService.addEmployee(e);
    //}
    public ResponseEntity<AddEmployeeResponse> addEmployees(@RequestBody AddEmployeeRequest e){
        Employee E=employeeService.addEmployee(e);
        AddEmployeeResponse addEmployeeResponse=new AddEmployeeResponse("Employee added successfully with Employee ID : ",E.getId());
        return ResponseEntity.ok(addEmployeeResponse);
    }

    //updating employee by id
    @PutMapping("/employees/{id}")
    public ResponseEntity<UpdateEmployeeResponse> updateEmployees(@RequestBody UpdateEmployeeRequest updateEmployeeRequest , @PathVariable int id){

        //employeeService.updateEmployee(e,id);
        Employee emp= employeeService.updateEmployee(updateEmployeeRequest,id);
        UpdateEmployeeResponse updateEmployeeResponse;
        if(emp==null)
        {
            updateEmployeeResponse=new UpdateEmployeeResponse(null,"no employee found for this id");
            return ResponseEntity.ok(updateEmployeeResponse);
        }
        else{
            updateEmployeeResponse=new UpdateEmployeeResponse(emp,"employee updated successfully");
            return ResponseEntity.ok(updateEmployeeResponse);
        }

        //return ResponseEntity.ok(updateEmployeeResponse);
    }

    //delete all employee
    @DeleteMapping("/employees")
    public ResponseEntity<DeleteAllEmployeeResponse> deleteAllEmployees(){
        //employeeService.deleteAllEmployees();
        int count=employeeService.deleteAllEmployees();
        DeleteAllEmployeeResponse deleteAllEmployeeResponse;
        if(count==0)
        {
            deleteAllEmployeeResponse=new DeleteAllEmployeeResponse(count,"Employee Table is already empty");
        }
        else{

            deleteAllEmployeeResponse=new DeleteAllEmployeeResponse(count,"all records are successfully deleted");
        }
        return ResponseEntity.ok(deleteAllEmployeeResponse);
    }

    //delete by employee id
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<DeleteEmployeeByIdResponse> deleteEmployeeByID(@PathVariable int id){
    //employeeService.deleteEmployeeByID(id);
        DeleteEmployeeByIdResponse deleteEmployeeByIdResponse;
        if( employeeService.deleteEmployeeByID(id) )
        {
            deleteEmployeeByIdResponse =new DeleteEmployeeByIdResponse(" employee is successfully deleted");
        }
        else{
            deleteEmployeeByIdResponse =new DeleteEmployeeByIdResponse(" employee Not Found with given id");
        }
        return ResponseEntity.ok(deleteEmployeeByIdResponse);
    }
}
