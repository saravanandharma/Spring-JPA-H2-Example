package com.saravanan.springjpah2;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    protected Customer(){}

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
