package com.example.collections.service;

import com.example.collections.exception.EmployeeAlreadyAddedException;
import com.example.collections.exception.EmployeeNotFoundException;
import com.example.collections.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsKey(employee.getFullName())) {
            employeeList.remove(employee.getFullName());
            return employeeList.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsKey(employee.getFullName())) {
            return employeeList.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employeeList.values());
    }

}
