package com.demo.EMS.Services;

import com.demo.EMS.Entity.Department;

import java.util.List;

public interface DepartmentService {
    // fetching all department
    List<Department> getAllDepartments();

    // fetching department by id
    Department getDepartment(int id);

    // inserting department
    void addDepartment(Department d);

    // updating department by id
    void updateDepartment(Department d, int id);

    // deleting all departments
    void deleteAllDepartment();

    // deleting department by id
    void deleteDepartmentByID(int id);




}
