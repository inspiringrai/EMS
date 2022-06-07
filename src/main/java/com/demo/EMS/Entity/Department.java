package com.demo.EMS.Entity;


import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name="department_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String short_Name;
    private String department_Name;

    public Department(){

    }
    public Department(int id, String short_Name, String department_Name) {
        this.id = id;
        this.short_Name = short_Name;
        this.department_Name = department_Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShort_Name() {
        return short_Name;
    }

    public void setShort_Name(String short_Name) {
        this.short_Name = short_Name;
    }

    public String getDepartment_Name() {
        return department_Name;
    }

    public void setDepartment_Name(String department_Name) {
        this.department_Name = department_Name;
    }
}
