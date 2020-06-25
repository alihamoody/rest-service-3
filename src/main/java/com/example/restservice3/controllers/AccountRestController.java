package com.example.restservice3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice3.models.Account;
import com.example.restservice3.repositories.AccountRepository;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping(path = "/accounts") // URL base path for all other mappings inside the class
public class AccountRestController {

  @Autowired
  private AccountRepository accountRepository;

  public AccountRestController(AccountRepository accountRepository) {
      this.accountRepository = accountRepository;
  }

  // GET all accounts
  @GetMapping(value="")
  public @ResponseBody Iterable<Account> getAllAccounts() {
      return accountRepository.findAll();

      // List<Account> accountList = new ArrayList<>();
      // accountList.add(new Account(1L, "title1", "description1"));
      // accountList.add(new Account(2L, "title2", "description2"));
      // return accountList;
  }  
  
  @GetMapping(value="/{accountId}")
  public Account getAccountById(@PathVariable Long accountId) {
      //TODO: process GET by id request
      return new Account(accountId, "Title" + accountId, "description"+accountId);
  }
  
  @PostMapping(value="")
  public Account addAccount(@RequestBody Account account) {
      //TODO: process POST request
      return account;
  }
  
  @PutMapping(value="/{accountId}")
  public Account updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
      //TODO: process PUT request
      if(account.getId() != accountId) {
        return null;
      }
      return account;
  }
  
  @DeleteMapping(value="/{accountId}")
  public Long deleteAccount(@PathVariable Long accountId) {
      //TODO: process DELETE request
      return accountId;
  }
}