package com.raj.springcrud.repository;

import com.raj.springcrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
//    @Query("FROM Employee WHERE department.name=:name")
//    List<Employee> findByDepartmentName(String name);


    List<Employee>findByName(String name);

    //SELECT * FROM table WHERE name="Raj" AND location="India"
//    List<Employee>findByNameAndLocation(String name,String location);

    //SELECT * FROM table where name LIKE "%raj%"



    List<Employee> findByNameContaining(String keyword);

//    @Query("FROM Employee WHERE name=:name OR location=:location")
//    List<Employee> getEmployeessByNameAndLocation(String name, String location);
    @Transactional
    @Modifying
    @Query("DELETE FROM Employee WHERE name=:name")
    Integer deleteByEmployeeByName(String name);
}

