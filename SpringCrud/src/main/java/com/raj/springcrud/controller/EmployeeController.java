package com.raj.springcrud.controller;

import com.raj.springcrud.model.Department;
import com.raj.springcrud.model.Employee;
import com.raj.springcrud.repository.DepartmentRepository;
import com.raj.springcrud.repository.EmployeeRepository;
import com.raj.springcrud.request.EmployeeRequest;
import com.raj.springcrud.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
//RestController= Controller + ResponseBody
public class EmployeeController {
    @Autowired
    private EmployeeRepository eRepo;
    @Autowired
    private DepartmentRepository dRepo;
    @Autowired
    private EmployeeService eService;

    @Value("${app.name: Employee Tracker}")
    private String appName;
    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/version")
    public String getAppDetails(){
        return appName+ " - " + appVersion;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployee(){
//        return eService.getEmployee();

        return new ResponseEntity<List<Employee>>(eService.getEmployee(), HttpStatus.OK);
    }
//    @GetMapping("/employees")
//    public ResponseEntity<List<Employee>> getEmployee(@RequestParam Integer pageNumber,@RequestParam Integer pageSize){
//    //        return eService.getEmployee();
//
//        return new ResponseEntity<List<Employee>>(eService.getEmployee(pageNumber,pageSize), HttpStatus.OK);
//    }
//---------------------------------------------------------------------------------
//    @PostMapping("/employees")
//    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
//        return new ResponseEntity<>(eService.saveEmployee(employee),HttpStatus.CREATED);
//    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getSingleEmployee(@PathVariable("id")Long id){
        return new ResponseEntity<Employee>(eService.getSingleEmployee(id),HttpStatus.OK);

    }
//    public Employee getSingleEmployee(@PathVariable("id")Long id){
//        return eService.getSingleEmployee(id);
//
//    }
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id")Long id){

        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
//    public String deleteEmployee(@RequestParam("id")Long id){
//        eService.deleteEmployee(id);
//        return "deleted data "+id ;
//    }

//    @PutMapping("/employees/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
//        employee.setId(id);
//        return new ResponseEntity<Employee>(eService.updateEmployee(employee),HttpStatus.OK);
//
//    }
    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name){
        return new ResponseEntity<List<E    mployee>>(eService.getEmployeesByName(name),HttpStatus.OK);

    }
//    @GetMapping("/employees/filterByNameAndLocation")
//    public ResponseEntity<List<Employee>> getEmployeeByNameAndLocation(@RequestParam String name,@RequestParam String location){
//        return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameAndLocation(name,location),HttpStatus.OK);
//
//    }
    @GetMapping("/employees/filterByNameKeyword")
    public ResponseEntity<List<Employee>> getByContainingKeyword(@RequestParam String keyword){
        return new ResponseEntity<List<Employee>>(eService.getByContainingKeyword(keyword),HttpStatus.OK);

    }
//    @GetMapping("/employees/{name}/{location}")
//    public ResponseEntity<List<Employee>> getEmployeessByNameAndLocation(@PathVariable String name,@PathVariable String location){
//        return new ResponseEntity<List<Employee>>(eService.getEmployeessByNameAndLocation(name,location),HttpStatus.OK);
//
//    }

    @DeleteMapping("/employees/delete/{name}")
    public ResponseEntity<String> deleteByEmployeeName(@PathVariable String name){

        return new ResponseEntity<String>(eService.deleteByEmployeeName(name)+"No. of Record effected",HttpStatus.OK);
    }


    @PostMapping("/employeesnew")
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeRequest eRequest){
//        Employee employee =new Employee(eRequest);
//        employee=eRepo.save(employee);
        for (String s : eRequest.getDepartment()){
            Department d=new Department();
            d.setName(s);
            d.setSection(eRequest.getSection());
//            d.setEmployee(employee);
            dRepo.save(d);

        }
        return new ResponseEntity<String>("Record succefully saved",HttpStatus.CREATED);

    }
//    @RequestMapping(value = "/employee", method = RequestMethod.GET)
//    @ResponseBody
//    @GetMapping("/employee")
//    public String getEmployee(){
//        return "hello world";
//    }

//    @GetMapping("/employee/{id}")
//    public String getEmployee(@PathVariable("id")Long id){
//        return "Fatching the Employee Details for the id"+id;
//
//    }

//    @PostMapping("/employees")
//    public String saveEmployee(@RequestBody Employee employee){
//        return "save the employees details in database"+employee;
//    }
//    @PutMapping("/employees/{id}")
//    public String saveEmployee(@PathVariable Long id,@RequestBody Employee employee){
//        System.out.println("Update the data by id"+id);
//        return "Update the data by id"+employee;
//    }

//    @DeleteMapping("/employees")
//    public String deleteEmployee(@RequestParam("id")Long id){
//        return "Deleteing the Employee Details from the id"+id;
//
//    }


//    @GetMapping("/employeesdep/filter/{name}")
//    public ResponseEntity<List<Employee>> getEmployeeByDepartment(@PathVariable String name){
//        return new ResponseEntity<List<Employee>>(eRepo.findByDepartmentName(name),HttpStatus.OK);
//
//
//    }
}
