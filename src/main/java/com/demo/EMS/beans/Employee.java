package com.demo.EMS.beans;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {



    @Id
    @Column(name="employee_id")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String email;
    @NotNull
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    public Employee() {

    }
    public Employee(long id, String firstName, String lastName, String email,Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
