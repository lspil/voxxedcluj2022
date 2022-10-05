package com.example.ssw_e4.authorizations;

import com.example.ssw_e4.dto.Product;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class ProductAuthorizer {

  public boolean allow(Product product) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return authentication.getAuthorities()
        .stream()
        .anyMatch(t -> t.getAuthority().equals("ROLE_ADMIN"))
        && authentication.getName().equals(product.owner());
  }
}
