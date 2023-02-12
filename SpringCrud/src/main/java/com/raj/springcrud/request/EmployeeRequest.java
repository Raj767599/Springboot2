package com.raj.springcrud.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeRequest {
    private String name;
    private Long id;
    private String cabFacility;
    private String employeeDepartment;
    private String mealFacility;
    private String shiftTiming;
    private String slotRecurrence;
    private String vaccination;
    private String section;

    private List<String> department;
}
