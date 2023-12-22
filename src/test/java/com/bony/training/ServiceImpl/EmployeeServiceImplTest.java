package com.bony.training.ServiceImpl;

import com.bony.training.Repository.EmployeeRepo;
import com.bony.training.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeServiceImplTest {

    @Mock
    EmployeeRepo employeeRepo;
    @InjectMocks
    EmployeeServiceImpl employeeServiceImpl;


    @Test
    void test_getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(34L, "Kratarth", "Engineering", "Bangalore"));
        employeeList.add(new Employee(35L, "Rich Bony", "Engineering", "Berlin"));
        employeeList.add(new Employee(36L, "MJ", "Architect", "Noida"));

        //Mocking repository here
        when(employeeRepo.findAll()).thenReturn(employeeList);

        //ServiceImpl calls a method which uses repo, in that case mocked repo will be used
        assertEquals(3, employeeServiceImpl.getAllEmployees().size());

        //Mockito verify (more to read)
        verify(employeeRepo, times(1)).findAll();
    }

    @Test
    void test_getEmployeeById() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(34L, "Kratarth", "Engineering", "Bangalore"));
        employeeList.add(new Employee(35L, "MJ", "Architect", "Noida"));

        ///Mocking repo
        when(employeeRepo.findById(34L)).thenReturn(Optional.ofNullable(employeeList.get(0)));
        when(employeeRepo.findById(36L)).thenReturn(Optional.empty());

        Long employeeID = 34L;
        Employee actual = employeeServiceImpl.getEmployeeById(employeeID);
        Employee expected = employeeList.get(0);

        //ServiceImpl
        assertEquals(actual, expected);
    }

    @Test
    void saveEmployee() {
        Employee employee = new Employee(null, "Bony", "CTO", "London");
        Employee employee1 = new Employee(null, "Kratarth", "CEO", "Vienna");
        when(employeeRepo.save(employee)).thenReturn(employee);
        assertEquals(employeeServiceImpl.saveEmployee(employee), employee);
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee(null, "Bony", "CTO", "London");
        Employee employee1 = new Employee(null, "Kratarth", "CEO", "Vienna");
        when(employeeRepo.save(employee)).thenReturn(employee);
        assertEquals(employeeServiceImpl.saveEmployee(employee), employee);
    }

    @Test
    void deleteEmployeeById() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(34L, "Kratarth", "Engineering", "Bangalore"));
        employeeList.add(new Employee(35L, "MJ", "Architect", "Noida"));

        Long id = 34L;

        //Mocking repo again
        doNothing().when(employeeRepo).deleteById(id);

        //Service layer interacting with mocked repo
        employeeServiceImpl.deleteEmployeeById(id);

        verify(employeeRepo, times(1)).deleteById(id);
    }
}