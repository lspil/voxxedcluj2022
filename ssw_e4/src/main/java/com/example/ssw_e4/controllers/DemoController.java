package com.example.ssw_e4.controllers;

import com.example.ssw_e4.dto.Product;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

  @PostMapping("/buy")
  @PreAuthorize("@productAuthorizer.allow(#product)")
  public Product buy(@RequestBody Product product) {
    return product;
  }

}
