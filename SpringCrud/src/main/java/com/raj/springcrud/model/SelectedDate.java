package com.raj.springcrud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="Selected_Date")
public class SelectedDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id", referencedColumnName = "id")
//    List< Employee > depart = new ArrayList< >();

//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;
}
