package com.raj.springcrud.service;

import com.raj.springcrud.model.Employee;

import java.util.List;

public interface EmployeeService {
//    List<Employee> getEmployee(int pageNumber, int pageSize);
    List<Employee> getEmployee();
    Employee saveEmployee(Employee employee);
    Employee getSingleEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeesByName(String name);
//    List<Employee> getEmployeesByNameAndLocation(String name, String location);
    List<Employee> getByContainingKeyword(String keyword);

//    List<Employee> getEmployeessByNameAndLocation(String name,String location);

    Integer deleteByEmployeeName(String name);

}
