package com.bony.training.ServiceImpl;

import com.bony.training.Repository.EmployeeRepo;
import com.bony.training.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeServiceImplTest {

    @Mock
    EmployeeRepo employeeRepo;
    @InjectMocks
    EmployeeServiceImpl employeeServiceImpl;


    @Test
    void test_getAllEmployees(){

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(34L, "Kratarth", "Engineering", "Bangalore"));
        employeeList.add(new Employee(35L, "Rich Bony", "Engineering", "Berlin"));
        employeeList.add(new Employee(36L, "MJ", "Architect", "Noida"));

        //Mocking repository here
        when(employeeRepo.findAll()).thenReturn(employeeList);

        //ServiceImpl calls a method which uses repo, in that case mocked repo will be used
        Assertions.assertEquals(3, employeeServiceImpl.getAllEmployees().size());

        //Mockito verify (more to read)
        verify(employeeRepo, times(1)).findAll();
    }

    @Test
    void test_getEmployeeById() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(34L, "Kratarth", "Engineering", "Bangalore"));
        employeeList.add(new Employee(35L, "MJ", "Architect", "Noida"));



    }

    @Test
    void saveEmployee() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployeeById() {
    }
}