package com.example.ssw_e3.authorizators;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class XAuth {

  public boolean test(String smth) {
    var a = SecurityContextHolder.getContext().getAuthentication();
    return true;
  }
}
