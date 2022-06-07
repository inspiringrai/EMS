package com.demo.EMS.ServiceImpl;

import com.demo.EMS.Repository.EmployeeRepo;
import com.demo.EMS.Services.EmployeeService;
import com.demo.EMS.Entity.Employee;
import com.demo.EMS.dto.AddEmployeeRequest;
import com.demo.EMS.dto.UpdateEmployeeRequest;
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

    public Employee addEmployee(AddEmployeeRequest e){
        Employee emp = new Employee(e.getFirstName(),e.getLastName(),e.getEmail());
        return employeeRepo.save(emp);

    }

    public Employee updateEmployee(UpdateEmployeeRequest emp , int id){
        Employee e = employeeRepo.findById(id).orElse(null);

        if(e != null){
            if(emp.getFirstName()!=null)
                e.setFirstName(emp.getFirstName());
            if(emp.getLastName()!=null)
                e.setLastName(emp.getLastName());
            if(emp.getEmail()!=null)
                e.setEmail(emp.getEmail());
        }
        employeeRepo.save(e);
        return e;

    }

    public int deleteAllEmployees(){
        //employeeRepo.deleteAll();
        int  count= (int) employeeRepo.count();
        employeeRepo.deleteAll();
        return count;
    }

    public boolean deleteEmployeeByID(int id){

        //employeeRepo.deleteById(id);
        Employee e = employeeRepo.findById(id).orElse(null);
        if(e==null)
        {

            return false;
        }
        else{
            employeeRepo.deleteById(id);
            return true;
        }
    }
}
