package com.demo.EMS.ServiceImpl;

import com.demo.EMS.Repository.DepartmentRepo;
import com.demo.EMS.Services.DepartmentService;
import com.demo.EMS.beans.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    public List<Department> getAllDepartments() {
        List<Department> depts = (List<Department>)departmentRepo.findAll();
        return depts;
    }

    public Department getDepartment(int id){
        return departmentRepo.findById(id).orElse(null);
    }

    public void addDepartment(Department d){
        departmentRepo.save(d);
    }

    public void updateDepartment(Department d, int id){
            if(id == d.getId()) {
                departmentRepo.save(d);
            }
    }

    public void deleteAllDepartment(){
        departmentRepo.deleteAll();
    }

    public void deleteDepartmentByID(int id){
        departmentRepo.deleteById(id);
    }

}
