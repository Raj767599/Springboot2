package com.raj.springcrud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String section;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id", referencedColumnName = "id")
//    List< Employee > depart = new ArrayList< >();

//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;
}
