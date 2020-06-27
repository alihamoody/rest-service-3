package com.example.restservice3.controllers;

import org.hibernate.annotations.Parameter;
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
import org.springframework.web.bind.annotation.RequestParam;
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
  public @ResponseBody Iterable<Account> getAllAccounts(
    @RequestParam(defaultValue = "") String title,
    @RequestParam(defaultValue = "") String titleend,
    @RequestParam(defaultValue = "") String titlestart,
    @RequestParam(required = false) Long special) {
    if(special != null) {
      return accountRepository.findSpecial(special);
    }
    if(!title.isBlank()) {
      return accountRepository.findByTitleContaining(title);
    }
    if(!titleend.isBlank()) {
      return accountRepository.findByTitleEndsWith(titleend);
    }
    if(!titlestart.isBlank()) {
      return accountRepository.findByTitleStartsWith(titlestart);
    }

    return accountRepository.findAll();
  }  
  
  @PostMapping(value="")
  public @ResponseBody String addNewAccount(@RequestBody Account account) {
    Account newAccount = new Account(
      account.getTitle(), 
      account.getDescription(), 
      account.getPersonId()
    );
    // System.out.println(newAccount.getId());
    accountRepository.save(newAccount);
    // System.out.println(newAccount.getId());
    return "Saved";
  }

  @GetMapping(value="/{accountId}")
  public Optional<Account> getAccountById(@PathVariable Long accountId) {
    return accountRepository.findById(accountId);
  }
  
  @PutMapping(value="/{accountId}")
  public String updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
    Optional<Account> dbRecord = accountRepository.findById(accountId);
    if(dbRecord.isPresent()) {
      Account accountRecord = dbRecord.get();
      accountRecord.updateAccount(account);
      accountRepository.save(accountRecord);
      return "Updated";
    } else {
      return "Not found";
    }
  }
  
  @DeleteMapping(value="/{accountId}")
  public String deleteAccount(@PathVariable Long accountId) {
    try {
    accountRepository.deleteById(accountId);
    return "Deleted";
    } catch (Exception e) {
      return "Error. Unable to delete.";
    }
  }
}