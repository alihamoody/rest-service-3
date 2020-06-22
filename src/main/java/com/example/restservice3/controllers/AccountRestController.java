package com.example.restservice3.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.example.restservice3.models.Account;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class AccountRestController {

  @GetMapping(value="/accounts")
  public List<Account> getAccounts() {
      List<Account> accountList = new ArrayList<>();
      accountList.add(new Account(1L, "title1", "description1"));
      accountList.add(new Account(2L, "title2", "description2"));
      return accountList;
  }  
  
  @GetMapping(value="/accounts/{accountId}")
  public Account getAccountById(@PathVariable Long accountId) {
      return new Account(accountId, "Title" + accountId, "description"+accountId);
  }
  
  @PostMapping(value="/accounts")
  public Account addAccount(@RequestBody Account account) {
      //TODO: process POST request
      return account;
  }
  
  @PutMapping(value="accounts/{accountId}")
  public Account updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
      //TODO: process PUT request
      if(account.getId() != accountId) {
        return null;
      }
      return account;
  }
  
  @DeleteMapping(value="accounts/{accountId}")
  public Long deleteAccount(@PathVariable Long accountId) {
      //TODO: process DELETE request
      return accountId;
  }
}