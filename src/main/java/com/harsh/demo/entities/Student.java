package com.harsh.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int rollNo ;
    private String surname;
    private String state;
    private int phone;

}
