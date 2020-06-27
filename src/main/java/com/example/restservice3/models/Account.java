package com.example.restservice3.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Entity
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long personId;

  @Size(min = 3, max = 24)
  private String title;
  private String description; 

  public Account() {}
  
  public Account( String title, String description, Long personId) {
    this.title = title;
    this.description = description;
    this.personId = personId;
  }
  

  public void updateAccount(Account newData) {
    this.title = newData.getTitle();
    this.description = newData.getDescription();
    this.personId = newData.getPersonId();
  }


}