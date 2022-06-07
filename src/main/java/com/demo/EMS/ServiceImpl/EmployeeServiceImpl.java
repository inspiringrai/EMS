package com.demo.EMS.ServiceImpl;

import com.demo.EMS.Repository.EmployeeRepo;
import com.demo.EMS.Services.EmployeeService;
import com.demo.EMS.beans.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> emps = (List<Employee>) employeeRepo.findAll();
        return emps;
    }
    public Employee getEmployee(int id){
        return employeeRepo.findById(id).orElse(null) ;
    }

    public void addEmployee(Employee e){
        employeeRepo.save(e);

    }

    public void updateEmployee(Employee emp , int id){
        if(id == emp.getId()) {
            employeeRepo.save(emp);
        }
    }

    public void deleteAllEmployees(){
        employeeRepo.deleteAll();
    }

    public void deleteEmployeeByID(int id){
        employeeRepo.deleteById(id);
    }
}
