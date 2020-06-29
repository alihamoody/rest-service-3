package com.example.restservice3;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.restservice3.controllers.AccountRestController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

  @Autowired
  private AccountRestController controller;

  @Test
  public void contextLoads() throws Exception {
    assertNotNull(controller);
  }

}