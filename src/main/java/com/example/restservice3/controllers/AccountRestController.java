package com.example.restservice3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.example.restservice3.models.Account;

@RestController
public class AccountRestController {

  @GetMapping(value="/accounts")
  public List<Account> getAccounts() {
      List<Account> accountList = new ArrayList<>();
      accountList.add(new Account(1L, "title1", "description1"));
      accountList.add(new Account(2L, "title2", "description2"));
      return accountList;
  }   
  
}