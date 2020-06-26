package com.example.restservice3.repositories;

import com.example.restservice3.models.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
  public Iterable<Account> findByTitleContaining(String title);
}