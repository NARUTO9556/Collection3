package com.example.collections.service;

import com.example.collections.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    Collection<Employee> findAll();
}
