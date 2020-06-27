package com.example.restservice3.repositories;

import com.example.restservice3.models.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
  
  public Iterable<Account> findByTitleContaining(String in);
  public Iterable<Account> findByTitleStartsWith(String in);
  public Iterable<Account> findByTitleEndsWith(String in);

  @Query("select a from Account a where a.description like %?1%")
  public Iterable<Account> findSpecial(String chars);

}