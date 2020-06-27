package com.example.restservice3.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Entity
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Size(min = 1, max = 24)
  private String firstName;
  @Size(min = 1, max = 24)
  private String lastName; 

  public Person() {}
  
  public Person( String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

}