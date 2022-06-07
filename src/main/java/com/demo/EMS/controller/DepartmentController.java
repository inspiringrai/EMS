package com.demo.EMS.controller;

import com.demo.EMS.Services.DepartmentService;
import com.demo.EMS.Entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //displaying list of all department
    @GetMapping("/departments")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartments();
    }
    //displaying department by id
    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable int id){
        return departmentService.getDepartment(id);
    }

    //inserting into department
    @PostMapping("/departments")
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }

    //Updating
    @PutMapping("/deparments/{id}")
    public void updateDepartment(@RequestBody Department d , @PathVariable int id){
        departmentService.updateDepartment(d,id);
    }

    //deleting all department
    @DeleteMapping("/departments/{id}")
    public void deleteDepartmentbyID(@PathVariable int id){
        departmentService.deleteDepartmentByID(id);
    }


}
