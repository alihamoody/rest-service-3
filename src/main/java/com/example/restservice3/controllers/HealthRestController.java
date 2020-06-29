package com.example.restservice3.controllers;

import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthRestController {

  @GetMapping(value="/health")
  public String getHealth() {
      return "Service is up and running. " + Instant.now().toString();
  }

  @GetMapping(value="/hello")
  public String getHello() {
      return "Hello World!";
  }



  

}