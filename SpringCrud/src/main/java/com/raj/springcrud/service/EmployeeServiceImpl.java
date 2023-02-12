package com.raj.springcrud.service;

import com.raj.springcrud.model.Employee;
import com.raj.springcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository eRepository;


//    public List<Employee> getEmployee(int pageNumber, int pageSize) {
//        Pageable pages=PageRequest.of(pageNumber,pageSize);
//        return eRepository.findAll(pages).getContent();
//    }
    @Override
    public List<Employee> getEmployee() {
        return eRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
       Optional<Employee> employee=eRepository.findById(id);
       if(employee.isPresent()){
           return employee.get();
       }
       throw new RuntimeException("Employee not found by id "+id);
    }

    @Override
    public void deleteEmployee(Long id) {
        eRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return eRepository.findByName(name);
    }

//    @Override
//    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
//        return eRepository.findByNameAndLocation(name,location);
//    }

    @Override
    public List<Employee> getByContainingKeyword(String keyword) {
        return eRepository.findByNameContaining(keyword);
    }

//    @Override
//    public List<Employee> getEmployeessByNameAndLocation(String name, String location) {
//        return eRepository.getEmployeessByNameAndLocation(name, location);
//    }

    @Override
    public Integer deleteByEmployeeName(String name) {
        return eRepository.deleteByEmployeeByName(name);
    }


//    private static List<Employee> list=new ArrayList<>();

//    static {
//        Employee e=new Employee();
//        e.setName("Raj");
//        e.setAge(35L);
//        e.setEmail("Raj@gmail.com");
//        e.setLocation("India");
//        e.setDepartment("IT");
//        list.add(e);
//
//        e=new Employee();
//        e.setName("Rahul");
//        e.setAge(35L);
//        e.setEmail("Rahul@gmail.com");
//        e.setLocation("India");
//        e.setDepartment("IT");
//        list.add(e);
//    }

//    @Override
//    public List<Employee> getEmployee() {
//        return list;
//    }



}
