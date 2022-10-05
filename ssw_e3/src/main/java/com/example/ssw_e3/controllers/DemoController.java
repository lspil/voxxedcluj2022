package com.example.ssw_e3.controllers;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo")
// @PreAuthorize @PostAuthorize @PreFilter @PostFilter
public class DemoController {

  @GetMapping("/a")
  @PreAuthorize("hasAuthority('read')")
  public String demoA() {
    return "Demo A";
  }

  @GetMapping("/b")
  public String demoB() {
    return "Demo B";
  }

  @GetMapping("/c")
  @PreFilter("filterObject.contains('a') ")
  public void demoC(@RequestBody List<String> strings) {
    System.out.println(strings);
  }

  @GetMapping("/d/{smth}")
  @PreAuthorize("@XAuth.test(#smth)")
  @PostFilter("filterObject.contains('a') ")
  public List<String> demoD(@PathVariable String smth) {
    List<String> list = new ArrayList<>();
    list.add("a");
    return list;
  }

}
