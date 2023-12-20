package com.bony.training.entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_ID")
    private Long employeeID;
    @Column(name = "employee_name", nullable = false)
    private String employeeName;
    @Column(name = "dept", nullable = false)
    private String department;
    @Column(name = "city")
    private String city;

    public Employee() {
    }

    public Employee(Long employeeID, String name, String department, String city) {
        this.employeeID = employeeID;
        this.employeeName = name;
        this.department = department;
        this.city = city;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", department='" + department + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
