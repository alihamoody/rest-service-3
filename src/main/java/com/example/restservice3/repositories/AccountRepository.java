package com.example.restservice3.repositories;

import com.example.restservice3.models.Account;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
  
}