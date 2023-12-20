package com.bony.training.controller;

import com.bony.training.entity.Employee;
import com.bony.training.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @SuppressWarnings({"unchecked", "raw types"})
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> list = employeeService.getAllEmployees();
        if(!list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if(employee != null){
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return this.employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return this.employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable long employeeId) {
        try {
            employeeService.deleteEmployeeById(employeeId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
