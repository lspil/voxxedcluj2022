package com.example.ssw_e5_rs.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @GetMapping("/demo")
  @PreAuthorize("hasAuthority('read')")
  public String demo() {
    return "Demo";
  }

  @GetMapping("/test")
  public String test() {
    return "Test";
  }
}
