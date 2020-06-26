package com.example.restservice3.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String description; 

  public Account() {}
  
  public Account( String title, String description) {
    this.title = title;
    this.description = description;
  }
  

  public void updateAccount(Account newData) {
    this.title = newData.getTitle();
    this.description = newData.getDescription();
  }


}