package com.example.restservice3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
  
  @PostMapping(value="")
  public @ResponseBody String addNewAccount(@RequestBody Account account) {
    Account newAccount = new Account(account.getTitle(), account.getDescription());
    // System.out.println(newAccount.getId());
    accountRepository.save(newAccount);
    // System.out.println(newAccount.getId());
    return "Saved";
  }

  @GetMapping(value="/{accountId}")
  public Optional<Account> getAccountById(@PathVariable Long accountId) {
    return accountRepository.findById(accountId);
  }
  
  // @PutMapping(value="/{accountId}")
  // public Account updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
  //     //TODO: process PUT request
  //     if(account.getId() != accountId) {
  //       return null;
  //     }
  //     return account;
  // }
  
  // @DeleteMapping(value="/{accountId}")
  // public Long deleteAccount(@PathVariable Long accountId) {
  //     //TODO: process DELETE request
  //     return accountId;
  // }
}