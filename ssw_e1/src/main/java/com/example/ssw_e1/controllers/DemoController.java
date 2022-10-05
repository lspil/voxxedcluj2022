package com.example.ssw_e1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

  @GetMapping("/a")
  public String demoA() {
    return "Demo A";
  }

  @GetMapping("/b")
  public String demoB() {
    return "Demo B";
  }
}
